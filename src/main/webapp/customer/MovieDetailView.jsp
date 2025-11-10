<%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 9/27/2025
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="d-flex justify-content-center align-items-center flex-column">
    <h1 class="mb-4">Hệ thống rạp chiếu phim Cineman</h1>
    <hr/>
    <c:if test="${not empty movie}">
        <h2>${movie.name}</h2>
        <c:set var="rawLength" value="${movie.length}" />

        <fmt:parseNumber var="hours" integerOnly="true" value="${rawLength}" />

        <c:set var="minutesDecimal" value="${(rawLength - hours) * 60}" />
        <fmt:formatNumber var="minutes" value="${minutesDecimal}" maxFractionDigits="0" />
        <h4>Thời lượng: ${hours} giờ ${minutes} phút</h4>
        <div class="border rounded p-3 bg-light">${movie.description}</div>
    </c:if>

    <button class="btn btn-primary" type="button" onclick="history.back()">Đóng</button>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
