<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>include액션태그 1</title>
	</head>
	<body>
	<h3>includeAction1.jsp입니다</h3>
	<hr>
	<jsp:include page = "includeAction2.jsp" flush = "true"/>
	</body>
</html>