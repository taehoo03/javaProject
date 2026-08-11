package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public Connection getConnection() {
		Connection con =null;
	//외부 자원 활용  : try catch 구문 안에서 진행되거나 throws 문을 추가하거나
	try {
		//dbms 연결 관련 코드
		//JDBC 드라이버 클래스의 객체 생성: 런타임시 JDBC 드라이버 로드(자동 로드 : 생략 가능)
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		//접속 면수 생성
		//"oracle 접속종류:@dbms 주소(도메인,ip):포트sid 또는 포트/서비스  name
		String url = "jdbc:oracle:thin:@localhost:29889/xepdb1";
		String user = "sql_select";
		String pwd = "1234";
		
		
		//2.Connection interface 참조변수에 구현 객체 대입(db접속 후 접속 객체 반환)
		con = DriverManager.getConnection(url,user,pwd);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return con;
		
	}
}
