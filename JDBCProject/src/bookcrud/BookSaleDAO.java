package bookcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookSaleDAO {
    private DBConn db = new DBConn();

    public void insertSale(BookSale s) {
        String sql = "INSERT INTO BOOKSALE (BSNO, BSDATE, BSQTY, BOOKNO, CLIENTNO) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, s.getBsNo());
            pstmt.setDate(2, s.getBsDate());
            pstmt.setString(3, s.getBsQty());
            pstmt.setString(4, s.getBookNo());
            pstmt.setString(5, s.getClientNo());
            pstmt.executeUpdate();
            System.out.println("성공 : 판매 정보가 등록되었습니다.");
        } catch (Exception e) {
            System.out.println("판매 등록 실패");
            e.printStackTrace();
        }
    }

    public void selectSale() {
        String sql = "SELECT * FROM BOOKSALE ORDER BY BSNO";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n********************");
            System.out.println("판매 정보 조회");
            System.out.println("********************");

            while (rs.next()) {
                System.out.println("판매번호 : " + rs.getString("BSNO"));
                System.out.println("판매일 : " + rs.getDate("BSDATE"));
                System.out.println("판매수량 : " + rs.getString("BSQTY"));
                System.out.println("도서번호 : " + rs.getString("BOOKNO"));
                System.out.println("고객번호 : " + rs.getString("CLIENTNO"));
                System.out.println("--------------------");
            }
        } catch (Exception e) {
            System.out.println("판매 조회 실패");
            e.printStackTrace();
        }
    }

    public void updateSale(BookSale s) {
        String sql = "UPDATE BOOKSALE SET BSDATE=?, BSQTY=?, BOOKNO=?, CLIENTNO=? WHERE BSNO=?";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setDate(1, s.getBsDate());
            pstmt.setString(2, s.getBsQty());
            pstmt.setString(3, s.getBookNo());
            pstmt.setString(4, s.getClientNo());
            pstmt.setString(5, s.getBsNo());

            if (pstmt.executeUpdate() > 0)
                System.out.println("성공 : 판매 정보가 수정되었습니다.");
            else
                System.out.println("해당 판매 정보가 없습니다.");
        } catch (Exception e) {
            System.out.println("판매 수정 실패");
            e.printStackTrace();
        }
    }

    public void deleteSale(String bsNo) {
        String sql = "DELETE FROM BOOKSALE WHERE BSNO=?";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, bsNo);

            if (pstmt.executeUpdate() > 0)
                System.out.println("성공 : 판매 정보가 삭제되었습니다.");
            else
                System.out.println("해당 판매 정보가 없습니다.");
        } catch (Exception e) {
            System.out.println("판매 삭제 실패");
            e.printStackTrace();
        }
    }
}
