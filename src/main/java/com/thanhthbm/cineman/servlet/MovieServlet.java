package com.thanhthbm.cineman.servlet;

import com.thanhthbm.cineman.dao.MovieDAO;
import com.thanhthbm.cineman.model.Movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/movies")
public class MovieServlet extends HttpServlet {
  private final MovieDAO movieDAO = new MovieDAO();


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      response.sendRedirect(request.getContextPath() + "/home");
      return;
    }

    switch(action){
      case "search":
        String name = request.getParameter("name");

        if (name != null && !name.trim().isEmpty()) {
          List<Movie> listMovie = this.movieDAO.searchMovieByName(name);
          request.setAttribute("listMovie", listMovie);
          request.getSession().setAttribute("listMovie", listMovie);
        } else {
          request.setAttribute("listMovie", new ArrayList<Movie>());
        }

        request.getRequestDispatcher("/customer/SearchMovieView.jsp").forward(request, response);
        break;
      case "details":
        String id = request.getParameter("id");
        if (id != null) {
          List<Movie> list = (List<Movie>) request.getSession().getAttribute("listMovie");

          Movie m = null;

          for (Movie movie : list){
            if (movie.getId() == Integer.parseInt(id)){
              m = movie;
              break;
            }
          }

          request.setAttribute("movie", m);
          request.getRequestDispatcher("/customer/MovieDetailView.jsp").forward(request, response);
        }

      default:
        response.sendRedirect(request.getContextPath() + "/home");
        break;
    }
  }

}
