package servletresponse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	getpost 요청시 처리 내용이 동일하다면
 *처리 메소드를 새로 생성해서 처리만 담당
 *doProcess(request,response) doHandle(request,response)
 */
@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 톰캣에 의해 호출: 외부 시스템과 접목되는 지점 ->  비지니스 처리를 진행하지는 않음
	 * 
	 * 
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response)

}
