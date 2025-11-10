<%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 9/27/2025
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm kiếm phim</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>


<body>
    <div class="d-flex justify-content-center align-items-center flex-column">
        <h1 class="mb-4">Hệ thống rạp chiếu phim Cineman</h1>
        <hr/>
        <h1>Tìm kiếm phim</h1>
        <form class="d-flex justify-content-center mb-4" method="get" action="${pageContext.request.contextPath}/movies">
            <div class="input-group" style="max-width: 900px;">
                <input type="hidden" name="action" value="search">
                <input type="text" name="name" class="form-control" placeholder="Nhập tên phim" value="${param.name}" />
                <button type="submit" class="btn btn-primary">Tìm kiếm</button>
            </div>
        </form>

        <c:if test="${not empty listMovie}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên phim</th>
                    <th>Xem chi tiết</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="movie" items="${listMovie}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${movie.name}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/movies?action=details&id=${movie.id}"
                               class="btn btn-info btn-sm">
                                Xem chi tiết
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

        <div>
            <a class="btn btn-danger" href="${pageContext.request.contextPath}/home">Quay lại</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>
