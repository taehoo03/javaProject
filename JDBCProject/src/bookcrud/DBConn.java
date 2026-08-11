package bookcrud;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

    private static final String URL = "jdbc:oracle:thin:@localhost:29889/XEPDB1";
    private static final String USER = "SQL_SELECT";
    private static final String PASSWORD = "1234";

    public Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("DB 연결 실패");
            e.printStackTrace();
        }

        return con;
    }
}
