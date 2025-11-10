<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Thống kê khách hàng</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container my-4">
    <h1 class="text-center mb-4">Hệ thống rạp chiếu phim Cineman</h1>
    <hr/>
    <h3 class="text-center mb-4">XEM THỐNG KÊ KHÁCH HÀNG THEO DOANH THU</h3>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
                ${errorMessage}
        </div>
    </c:if>
    <fmt:formatDate value="${requestScope.startDate}" pattern="yyyy-MM-dd" var="formattedStartDate" />
    <fmt:formatDate value="${requestScope.endDate}" pattern="yyyy-MM-dd" var="formattedEndDate" />


    <form method="get" action="${pageContext.request.contextPath}/customerStats" class="mb-4">
        <input type="hidden" name="action" value="viewReports">
        <div class="row mb-2 justify-content-center">
            <div class="col-auto">
                <label for="startDate" class="form-label">Chọn ngày bắt đầu</label>
                <input type="date" class="form-control" id="startDate" min="1997-01-01" max="2030-12-31"  name="startDate" value="${formattedStartDate}">
            </div>
            <div class="col-auto">
                <label for="endDate" class="form-label">Chọn ngày kết thúc</label>
                <input type="date" class="form-control" id="endDate" min="1997-01-01" max="2030-12-31" name="endDate" value="${formattedEndDate}">
            </div>
            <div class="col-auto d-flex align-items-end">
                <button type="submit" class="btn btn-primary">Xem</button>
            </div>
        </div>
    </form>

    <table class="table table-bordered table-hover table-sm align-middle">
        <thead class="table-light">
        <tr class="text-center">
            <th>STT</th>
            <th>Tên khách hàng</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Tổng doanh thu (VND)</th>
            <th>Xem</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="stats" items="${customerStatsList}" varStatus="loop">
            <tr>
                <td class="text-center">${loop.count}</td>

                <td>${stats.name}</td>
                <td>${stats.email}</td>
                <td>${stats.phone}</td>
                <td>${stats.total}</td>
                <td class="text-center">
                    <a href="customerStats?action=viewDetail&customerId=${stats.id}&startDate=${formattedStartDate}&endDate=${formattedEndDate}">Xem</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <div class="text-center mt-4">
        <a href="/viewStats" class="btn btn-secondary">Quay lại</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>