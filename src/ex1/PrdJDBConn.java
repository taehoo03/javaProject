package ex1;

import java.sql.Connection;
import java.sql.DriverManager;

public class PrdJDBConn {

		public Connection getConnection() {
			
			Connection con = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:29889/xepdb1",
					"sql_select",
					"1234"
				);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return con;
		}
	}

