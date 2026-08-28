<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%
		//변수 선언과 초기화 기능을 하는 선언부 jsp태그
		//위치는 어디에 있엉도 상관 없음 사용 전에만 나타나면 됨
		int x =10; //선언하면서 초기화 가능
		long y; // 선언만 가능
		//y= 100; // 이 경우엔 오류 ( 선언부에서 값 지정 불가능)
		float floatValue = 3.14F;
		double doubleValue = 3.14;
		
		char ch = 'a';
		boolean b = true;
		String myJob = " 프로게이머";
		
	
	%>
	<%
		//스크립트릿 - 자바코드 표현 부분
		//선언부에서 선언한 변수에 값 저장
		y= 100;
	
	
	%>
	
	<h3>변수 값 출력</h3>
	x:  <%=x %><br>
	y:  <%=y %><br>
	floarValue:  <%=floatValue %><br>
	doubleValue:  <%=doubleValue %><br>
	ch:  <%=ch %><br>
	b:  <%=b %><br>
	myJob:  <%=myJob %>






	</body>
</html>