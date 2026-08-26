package servletrequest;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * httpServletrequest 클래스 메소드 확인
 * http://localhost:8080/xxxx/login 요청을 처리하는 서블릿
 */
@SuppressWarnings("serial")
@WebServlet("/login") // html form 태그의 action "login"
public class LoginServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init 실행");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        System.out.println("destroy 실행");
    }

    /**
     * 클라이언트가 form 태그를 통해서 전송한 데이터 처리
     * HttpServletRequest 객체 : 클라이언트 요청 시 발생된 모든 정보와
     * 요청할 때 같이 전달된 클라이언트 입력 데이터를 갖고 있음
     * 모든 네트워크 데이터는 1바이트 데이터로 구성 후 전송됨
     * 데이터 중 결합 데이터는 네트워크로 전송 시 분리되므로 사용 전에 결합해야 함
     * 결합할 때 encoding 방식을 전달해야 함
     * -> HttpServletRequest.setCharacterEncoding("utf-8")
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        // request 객체 내 모든 정보에 대한 결합 방식은 utf-8로 설정

        // 클라이언트가 전송한 데이터 추출
        // HttpServletRequest.getParameter(name);
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");

        System.out.println("아이디 : " + user_id);
        System.out.println("비밀번호 : " + user_pw);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	System.out.println("Post 방식의 전송");
        String user_id = request.getParameter("user_id1");
        String user_pw = request.getParameter("user_pw1");
        System.out.println("아이디 : " + user_id);
        System.out.println("비밀번호 : " + user_pw);
    }
}