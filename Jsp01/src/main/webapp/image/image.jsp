<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>c:url 사용</title>
		<link href="<c:url value='/css/index.css' />"/>
		<script type = "text/jsvascript"src="<c:url value='/js/index.js'/>"></script>
	</head>
	<body>
	<img src ="/image/apple.png">
	<img src = "/image/apple.png">
	<img src = "<c:url value='/image/apple.png'/>">

	</body>
</html>