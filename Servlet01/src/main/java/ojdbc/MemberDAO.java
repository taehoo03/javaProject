package ojdbc;

import java.sql.Connection;

public class MemberDAO {
	private Connection getConnection() {
		Connection con =null;
		
		try {
			class.forName("oracle.driver.OracleDriver");
		}catch(Exception E) {
			
		}
	}
}

