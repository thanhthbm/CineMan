<%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 9/27/2025
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chọn kiểu thống kê</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h2 class="text-center mt-5">Xem thống kê</h2>

<div class="text-center mt-4">
    <div class="mx-auto mt-4" style="max-width: 300px;">
        <button class="btn btn-primary w-100 mb-2" onclick="location.href='stat-customer'">
            Thống kê khách hàng theo doanh thu
        </button>
        <button class="btn btn-primary w-100 mb-2" onclick="location.href='stat-movie'">
            Thống kê phim theo doanh thu
        </button>
        <button class="btn btn-primary w-100 mb-4" onclick="location.href='stat-revenue'">
            Thống kê doanh thu
        </button>
    </div>
    <button class="btn btn-danger" onclick="location.href='home'">Quay lại</button>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
