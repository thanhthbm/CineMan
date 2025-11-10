package com.thanhthbm.cineman.servlet;

import com.thanhthbm.cineman.dao.CustomerStatsDAO;
import com.thanhthbm.cineman.dao.InvoiceDAO;
import com.thanhthbm.cineman.model.Customer;
import com.thanhthbm.cineman.model.CustomerStats;
import com.thanhthbm.cineman.model.Invoice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/customerStats")
public class CustomerStatsServlet extends HttpServlet {
  private final CustomerStatsDAO customerStatsDAO = new CustomerStatsDAO();
  private final InvoiceDAO invoiceDAO = new InvoiceDAO();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String action = request.getParameter("action");
    if (action == null) action = "default";

    switch (action) {
      case "viewReports": {
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
          Date startDate = sdf.parse(startDateStr);
          Date endDate = sdf.parse(endDateStr);

          List<CustomerStats> statsList = customerStatsDAO.getCustomerStats(startDate, endDate);
          request.getSession().setAttribute("customerStatsList", statsList);
          request.setAttribute("startDate", startDate);
          request.setAttribute("endDate", endDate);

          request.getRequestDispatcher("/manager/CustomerReportView.jsp")
              .forward(request, response);

        } catch (ParseException e) {
          e.printStackTrace();
          request.setAttribute("error", "Sai định dạng ngày (yyyy-MM-dd)");
          request.getRequestDispatcher("/manager/CustomerReportView.jsp")
              .forward(request, response);
        }
        break;
      }

      case "viewDetail": {
        String customerIdStr = request.getParameter("customerId");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        if (customerIdStr == null || startDateStr == null || endDateStr == null) {
          request.setAttribute("error", "Thiếu tham số bắt buộc.");
          request.getRequestDispatcher("/manager/CustomerReportView.jsp")
              .forward(request, response);
          break;
        }

        try {
          int customerId = Integer.parseInt(customerIdStr);
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          Date startDate = sdf.parse(startDateStr);
          Date endDate = sdf.parse(endDateStr);

          Customer customer = new Customer();
          customer.setId(customerId);

          List<Invoice> invoiceList = invoiceDAO.getInvoiceByCustomer(customer, startDate, endDate);
          request.setAttribute("invoiceList", invoiceList);
          request.setAttribute("startDate", startDateStr);
          request.setAttribute("endDate", endDateStr);

          request.getRequestDispatcher("/manager/CustomerReportDetailView.jsp")
              .forward(request, response);

        } catch (NumberFormatException e) {
          request.setAttribute("error", "Mã khách hàng không hợp lệ.");
          request.getRequestDispatcher("/manager/CustomerReportView.jsp")
              .forward(request, response);
        } catch (ParseException e) {
          request.setAttribute("error", "Sai định dạng ngày (yyyy-MM-dd)");
          request.getRequestDispatcher("/manager/CustomerReportView.jsp")
              .forward(request, response);
        }
        break;
      }

      default: {
        request.getRequestDispatcher("/manager/CustomerReportView.jsp")
            .forward(request, response);
        break;
      }
    }
  }
}
