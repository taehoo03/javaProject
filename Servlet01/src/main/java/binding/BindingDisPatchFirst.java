package binding;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BindingDisPatchFirst
 */
@WebServlet("/dispatchfirst")
public class BindingDisPatchFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * 호출될때 전달받은 request 객체에 속성을 포함하여 포워딩
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		request.setAttribute("name", "홍길동");
		request.setAttribute("address", "서울시 강남구");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("dispatchsecond");
		dispatch.forward(request, response);
	}



}
