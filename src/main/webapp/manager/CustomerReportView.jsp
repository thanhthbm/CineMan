<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thống kê khách hàng</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container my-4">
    <h3 class="text-center mb-4">XEM THỐNG KÊ KHÁCH HÀNG THEO DOANH THU</h3>

    <!-- Bộ lọc ngày -->
    <form method="get" action="stat-customer" class="mb-4">
        <div class="row mb-2 justify-content-center">
            <div class="col-auto">
                <label for="startDate" class="form-label">Chọn ngày bắt đầu</label>
                <input type="date" class="form-control" id="startDate" name="startDate">
            </div>
            <div class="col-auto">
                <label for="endDate" class="form-label">Chọn ngày kết thúc</label>
                <input type="date" class="form-control" id="endDate" name="endDate">
            </div>
            <div class="col-auto d-flex align-items-end">
                <button type="submit" class="btn btn-primary">Xem</button>
            </div>
        </div>
    </form>

    <!-- Bảng kết quả -->
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
        <tr>
            <td class="text-center">1</td>
            <td>Nguyễn Văn Nam</td>
            <td>nam@gmail.com</td>
            <td>0907123456</td>
            <td class="text-end">1,870,000</td>
            <td class="text-center"><a href="#">Xem</a></td>
        </tr>
        <tr>
            <td class="text-center">2</td>
            <td>Lê Huyền Vân</td>
            <td>van@gmail.com</td>
            <td>0987256321</td>
            <td class="text-end">870,000</td>
            <td class="text-center"><a href="#">Xem</a></td>
        </tr>
        <tr>
            <td class="text-center">3</td>
            <td>Nguyễn Văn A</td>
            <td>nva@gmail.com</td>
            <td>0907126013</td>
            <td class="text-end">540,000</td>
            <td class="text-center"><a href="#">Xem</a></td>
        </tr>
        <tr>
            <td class="text-center">4</td>
            <td>Phạm Quốc Dũng</td>
            <td>dung@gmail.com</td>
            <td>0938765213</td>
            <td class="text-end">620,000</td>
            <td class="text-center"><a href="#">Xem</a></td>
        </tr>
        </tbody>
    </table>

    <!-- Nút quay lại -->
    <div class="text-center mt-4">
        <a href="statistic" class="btn btn-secondary">Quay lại</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
