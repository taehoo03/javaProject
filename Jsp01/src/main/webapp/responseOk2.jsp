<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    String answer;
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>요청에 대한 응답 처리</title>
	</head>
	<body>
		<form>
		<%
			request.setCharacterEncoding("UTF-8");
		
		answer = request.getParameter("answer");
		
		if(answer.equals("서울")){
			response.sendRedirect("pass.jsp");
		}else{
			response.sendRedirect("fail.jsp");
		}
		
		
		
		%>
		
		
		
		</form>
	</body>
</html>