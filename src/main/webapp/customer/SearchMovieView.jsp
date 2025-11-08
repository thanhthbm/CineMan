<%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 9/27/2025
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm kiếm phim</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>


<body>
    <div class="d-flex justify-content-center align-items-center flex-column">
        <h1>Tìm kiếm phim</h1>
        <form class="d-flex justify-content-center mb-4" method="get" action="${pageContext.request.contextPath}/search">
            <div class="input-group" style="max-width: 900px;">
                <input type="text" name="q" class="form-control" placeholder="Nhập tên phim" />
                <button type="submit" class="btn btn-primary">Tìm kiếm</button>
            </div>
        </form>

        <div>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Tên phim</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Đất rừng phương Nam</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/MovieDetailView.jsp?id=1"
                                    class="btn btn-primary btn-sm"
                                Xem chi tiết
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Doraemon: Nobita và Vùng đất lý tưởng</td>
                        <td>
                            <a      href="${pageContext.request.contextPath}/MovieDetailView.jsp?id=1"
                                    class="btn btn-primary btn-sm"
                                Xem chi tiết
                            </a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div>
            <button class="btn btn-danger">Quay lại</button>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>
