<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết giao dịch</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container my-4">
    <!-- Hàng tiêu đề + nút đóng -->
    <div class="d-flex justify-content-between align-items-center mb-3">
        <div></div>
        <h5 class="text-center m-0">Chi tiết giao dịch - Phạm Quốc Dũng</h5>
    </div>

    <!-- Bảng chi tiết vé -->
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
        <tr>
            <td>INV-20250820-0942</td>
            <td>20/08/2025 17:25</td>
            <td>Vũ Minh Châu</td>
            <td>V-2001</td>
            <td>C7</td>
            <td class="text-end">210,000</td>
            <td>The Garfield Movie</td>
            <td class="text-center">17:20</td>
            <td class="text-center">19:00</td>
            <td class="text-center">P2</td>
        </tr>
        <tr>
            <td>INV-20250820-0942</td>
            <td>20/08/2025 17:25</td>
            <td>Vũ Minh Châu</td>
            <td>V-2002</td>
            <td>C8</td>
            <td class="text-end">210,000</td>
            <td>The Garfield Movie</td>
            <td class="text-center">17:20</td>
            <td class="text-center">19:00</td>
            <td class="text-center">P2</td>
        </tr>
        </tbody>
    </table>

    <!-- Nút quay lại -->
    <div class="text-center mt-3">
        <a href="stat-customer" class="btn btn-secondary">Quay lại</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
