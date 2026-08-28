package exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookInsert")
public class bookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String bookNo = request.getParameter("bookNo");
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        String price = request.getParameter("price");

        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        String stock = request.getParameter("stock");
        String publisherNo = request.getParameter("publisherNo");

        System.out.println("init 메서드 호출");
        System.out.println("도서번호 : " + bookNo);
        System.out.println("도서명 : " + bookName);
        System.out.println("저자 : " + author);
        System.out.println("가격 : " + price);
        System.out.println("발행일 : " + year + "-" + month + "-" + day);
        System.out.println("재고 : " + stock);
        System.out.println("출판사번호 : " + publisherNo);
    }
}