package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertMember")
public class joinServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String jumin1 = request.getParameter("jumin1");
        String jumin2 = request.getParameter("jumin2");
        String grade = request.getParameter("grade");
        String[] interest = request.getParameterValues("interest");
        String department = request.getParameter("department");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>회원가입 내용</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>회원 가입 내용</h2>");

        out.println("성명 : " + name + "<br>");
        out.println("ID : " + id + "<br>");
        out.println("비밀번호 : " + pwd + "<br>");
        out.println("주민등록번호 : " + jumin1 + "-" + jumin2 + "<br>");
        out.println("학년 : " + grade + "<br>");

        out.print("관심분야 : ");

        if (interest != null) {
            for (String item : interest) {
                out.print(item + " ");
            }
        }

        out.println("<br>");

        out.println("학과 : " + department + "<br>");

        out.println("</body>");
        out.println("</html>");
    }
}