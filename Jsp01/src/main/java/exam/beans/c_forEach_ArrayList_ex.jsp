<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="exam.beans.ProductVO" %>

<%
    ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

    productList.add(new ProductVO("P001", "노트북", 1000000, "삼성"));
    productList.add(new ProductVO("P002", "스마트폰", 800000, "LG"));
    productList.add(new ProductVO("P003", "태블릿", 600000, "애플"));
    productList.add(new ProductVO("P004", "모니터", 300000, "삼성"));
    productList.add(new ProductVO("P005", "키보드", 50000, "로지텍"));

    request.setAttribute("productList", productList);

    RequestDispatcher dispatcher =
        request.getRequestDispatcher("c_forEach_ArrayList_result_ex.jsp");

    dispatcher.forward(request, response);
%>