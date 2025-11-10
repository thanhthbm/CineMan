<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.thanhthbm.cineman.model.Invoice" %>
<%@ page import="com.thanhthbm.cineman.model.Ticket" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    List<Invoice> invoiceList = (List<Invoice>) request.getAttribute("invoiceList");
    String customerName = invoiceList.get(0).getCustomer().getName();

    SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    SimpleDateFormat sdfTime     = new SimpleDateFormat("HH:mm");
    double totalAmount = 0;
    String startDate = (String) request.getAttribute("startDate");
    String endDate = (String) request.getAttribute("endDate");

%>

<html>
<head>
    <title>Chi tiết giao dịch</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div>
    <h1 class="mb-4 text-center">Hệ thống rạp chiếu phim Cineman</h1>
</div>
<hr/>

<div class="container my-4">

    <div class="d-flex justify-content-between align-items-center mb-3">

        <h5 class="text-center m-0">
            Chi tiết giao dịch - <%= (customerName != null ? customerName : "Khách hàng") %>
        </h5>
        <div>
            <h5>Ngày bắt đầu: ${startDate}</h5>
            <h5>Ngày kết thúc: ${endDate}</h5>
        </div>
    </div>

    <table class="table table-bordered table-hover table-sm align-middle">
        <thead class="table-light text-center">
        <tr>
            <th>Mã hóa đơn</th>
            <th>Thời gian xuất</th>
            <th>Nhân viên</th>
            <th>Mã vé</th>
            <th>Ghế</th>
            <th>Giá vé (VND)</th>
            <th>Phim</th>
            <th>Giờ bắt đầu</th>
            <th>Giờ kết thúc</th>
            <th>Phòng chiếu</th>
        </tr>
        </thead>

        <tbody>
        <%
            if (invoiceList != null) {
                for (Invoice inv : invoiceList) {
                    String invoiceIdStr   = String.valueOf(inv.getId());
                    String issueDateStr   = inv.getIssueDate() != null ? sdfDateTime.format(inv.getIssueDate()) : "";
                    String staffNameStr   = "";
                    if (inv instanceof com.thanhthbm.cineman.model.OnsiteInvoice) {
                        com.thanhthbm.cineman.model.OnsiteInvoice oi = (com.thanhthbm.cineman.model.OnsiteInvoice) inv;
                        if (oi.getStaff() != null) {
                            staffNameStr = oi.getStaff().getName();
                        }
                    } else if (inv instanceof com.thanhthbm.cineman.model.OnlineInvoice) {
                        staffNameStr = "(Online)";
                    }

                    if (inv.getTickets() != null) {
                        for (Ticket t : inv.getTickets()) {
                            String ticketIdStr = String.valueOf(t.getId());

                            double ticketPrice = t.getPrice();
                            String priceStr    = String.format("%,.0f", ticketPrice);
                            totalAmount += ticketPrice;

                            String seatNameStr = (t.getSeat() != null ? t.getSeat().getName() : "");


                            String movieNameStr = "";
                            String startTimeStr = "";
                            String endTimeStr   = "";
                            String roomNameStr  = "";

                            if (t.getShowtime() != null) {
                                if (t.getShowtime().getMovie() != null) {
                                    movieNameStr = t.getShowtime().getMovie().getName();
                                }
                                if (t.getShowtime().getStartTime() != null) {
                                    startTimeStr = t.getShowtime().getStartTime().toString();
                                }
                                if (t.getShowtime().getEndTime() != null) {
                                    endTimeStr = t.getShowtime().getEndTime().toString();
                                }
                                if (t.getShowtime().getScreenRoom() != null) {
                                    roomNameStr = t.getShowtime().getScreenRoom().getName();
                                }
                            }
        %>
        <tr>
            <td><%= invoiceIdStr %></td>
            <td><%= issueDateStr %></td>
            <td><%= staffNameStr %></td>
            <td><%= ticketIdStr %></td>
            <td><%= seatNameStr %></td>
            <td class="text-end"><%= priceStr %></td>
            <td><%= movieNameStr %></td>
            <td class="text-center"><%= startTimeStr %></td>
            <td class="text-center"><%= endTimeStr %></td>
            <td class="text-center"><%= roomNameStr %></td>
        </tr>

        <%
                        }
                    }
                }
            }
        %>
        <%
            String totalAmountStr = String.format("%,.0f", totalAmount);
        %>
        <tr class="table-group-divider">
            <td colspan="5" class="text-end fw-bold">Tổng cộng:</td>
            <td class="text-end fw-bold"><%= totalAmountStr %></td>
            <td colspan="4"></td>
        </tr>
        </tbody>
    </table>

    <div class="text-center mt-3">
        <a href="customerStats?action=viewReports&startDate=${startDate}&endDate=${endDate}"
           class="btn btn-secondary">
            Quay lại
        </a>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>