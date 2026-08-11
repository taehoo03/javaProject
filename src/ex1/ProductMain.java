package ex1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductMain {

	public static void main(String[] args) {

		PrdJDBConn db = new PrdJDBConn();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM PRODUCTFIN";

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				System.out.println(
						rs.getString(1) + " / " +
						rs.getString(2) + " / " +
						rs.getInt(3) + " / " +
						rs.getString(4) + " / " +
						rs.getString(5) + " / " +
						rs.getInt(6)
				);
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}