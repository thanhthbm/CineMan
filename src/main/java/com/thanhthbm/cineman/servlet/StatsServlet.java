package com.thanhthbm.cineman.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/viewStats")
public class StatsServlet extends HttpServlet {

  protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getSession().getAttribute("user") == null) {
      response.sendRedirect(request.getContextPath() + "/login");
      return;
    }
    request.getRequestDispatcher("/manager/SelectReportTypeView.jsp").forward(request, response);
  }
}
