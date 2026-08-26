package servlet01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://도메인:포트/context/파일명(매핑된url)
 * 자바(HTTP)패키지 제공
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        
    }

	/**
	 * service()메서드에 자동으로 호출되는 메서드
	 * 메모리에 올라올 때 한번 호출
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}

	/**
	 *메모리에서 삭제될 때 한번 호출
	 *서블릿 업데이트 되는경우 destory 메소드 호출하고 서블릿 없데이트 후 객체 생성
	 */
	public void destroy() {
		System.out.println("destory 메소드 호출");
	}

	/**
	 * 클라이언트 요청방식이 겟 방식일때 호출되는 메소드
	 * 서비스 메소드에 의해 호출
	 * service() : main() 메소드의 역할 , web container 에 의해 자동 호출
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doget 메소드 호출");
	}

}
