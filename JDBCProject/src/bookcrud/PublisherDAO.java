package bookcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PublisherDAO {
    private DBConn db = new DBConn();

    public void insertPublisher(Publisher p) {
        String sql = "INSERT INTO PUBLISHER (PUBNO, PUBNAME) VALUES (?, ?)";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, p.getPubNo());
            pstmt.setString(2, p.getPubName());
            pstmt.executeUpdate();
            System.out.println("성공 : 출판사 정보가 등록되었습니다.");
        } catch (Exception e) {
            System.out.println("출판사 등록 실패");
            e.printStackTrace();
        }
    }

    public void selectPublisher() {
        String sql = "SELECT * FROM PUBLISHER ORDER BY PUBNO";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n********************");
            System.out.println("출판사 정보 조회");
            System.out.println("********************");

            while (rs.next()) {
                System.out.println("출판사 번호 : " + rs.getString("PUBNO"));
                System.out.println("출판사명 : " + rs.getString("PUBNAME"));
                System.out.println("--------------------");
            }
        } catch (Exception e) {
            System.out.println("출판사 조회 실패");
            e.printStackTrace();
        }
    }

    public void updatePublisher(Publisher p) {
        String sql = "UPDATE PUBLISHER SET PUBNAME=? WHERE PUBNO=?";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, p.getPubName());
            pstmt.setString(2, p.getPubNo());

            if (pstmt.executeUpdate() > 0)
                System.out.println("성공 : 출판사 정보가 수정되었습니다.");
            else
                System.out.println("해당 출판사가 없습니다.");
        } catch (Exception e) {
            System.out.println("출판사 수정 실패");
            e.printStackTrace();
        }
    }

    public void deletePublisher(String pubNo) {
        String sql = "DELETE FROM PUBLISHER WHERE PUBNO=?";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, pubNo);

            if (pstmt.executeUpdate() > 0)
                System.out.println("성공 : 출판사 정보가 삭제되었습니다.");
            else
                System.out.println("해당 출판사가 없습니다.");
        } catch (Exception e) {
            System.out.println("출판사 삭제 실패");
            e.printStackTrace();
        }
    }
}
