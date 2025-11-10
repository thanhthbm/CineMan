package com.thanhthbm.cineman.servlet;

import com.thanhthbm.cineman.dao.UserDAO;
import com.thanhthbm.cineman.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/", "/login", "/logout", "/home"})
public class UserServlet extends HttpServlet {

  private final UserDAO userDAO = new UserDAO();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = request.getServletPath();
    String ctx = request.getContextPath();

    switch (path) {
      case "/":
      case "/login": {
        HttpSession s = request.getSession(false);
        if (s != null && s.getAttribute("user") != null) {
          response.sendRedirect(ctx + "/home");
          return;
        }
        request.getRequestDispatcher("/LoginView.jsp").forward(request, response);
        break;
      }

      case "/home": {
        HttpSession s = request.getSession(false);
        if (s == null || s.getAttribute("user") == null) {
          response.sendRedirect(ctx + "/login");
          return;
        }
        User user = (User) s.getAttribute("user");
        String role = user.getRole() == null ? "" : user.getRole().toLowerCase();
        switch (role) {
          case "customer":
            request.getRequestDispatcher("/customer/CustomerMainView.jsp").forward(request, response);
            break;
          case "manager":
            request.getRequestDispatcher("/manager/ManagerMainView.jsp").forward(request, response);
            break;
          default:
            response.sendRedirect(ctx + "/login");
            break;
        }
        break;
      }

      case "/logout": {
        HttpSession s = request.getSession(false);
        if (s != null) s.invalidate();
        response.sendRedirect(ctx + "/login");
        break;
      }

      default:
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = request.getServletPath();
    String ctx = request.getContextPath();

    if ("/login".equals(path)) {
      String username = request.getParameter("username");
      String password = request.getParameter("password");

      User loggedInUser = new User();
      loggedInUser.setUsername(username);
      loggedInUser.setPassword(password);

      boolean ok = userDAO.checkLogin(loggedInUser);
      if (!ok) {
        request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
        request.getRequestDispatcher("/LoginView.jsp").forward(request, response);
        return;
      }

      HttpSession session = request.getSession(true);
      session.setAttribute("user", loggedInUser);
      response.sendRedirect(ctx + "/home");
      return;
    }

    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
  }
}
