package servlet01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("SecondServlet init() 호출");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("SecondServlet doGet() 호출");

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<h1>SecondServlet 실행</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("SecondServlet destroy() 호출");
    }
}