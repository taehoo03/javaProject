<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>

<style>
    table {
        border-collapse: collapse;
        width: 700px;
    }

    th, td {
        border: 1px solid black;
        padding: 10px;
        text-align: center;
    }

    th {
        background-color: #eeeeee;
    }
</style>

</head>
<body>

<h2>상품 목록</h2>

<table> 
    <tr>
        <th>상품번호</th>
        <th>상품명</th>
        <th>가격</th>
        <th>제조사</th>
    </tr>

    <c:forEach var="product" items="${pro  ctList}">
        <tr>
            <td>${product.prdNo}</td>
            <td>${product.prdName}</td>
            <td>${product.prdPrice}</td>
            <td>${product.prdCompany}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>