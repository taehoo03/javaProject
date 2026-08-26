package servlet01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet {

}
@WebServlet("/ThirdServlet")
 public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdServlet() {
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
	 * 클라이언트 요청방식이 겟 방식일때 호출되는 메소드
	 * 서비스 메소드에 의해 호출
	 * service() : main() 메소드의 역할 , web container 에 의해 자동 호출
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doget 메소드 호출");
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost 메소드 호출");
	}
	
	

}
