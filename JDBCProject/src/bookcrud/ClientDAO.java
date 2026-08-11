package bookcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDAO {
    private DBConn db = new DBConn();

    public void insertClient(Client c) {
        String sql = "INSERT INTO CLIENT (CLIENTNO, CLIENTNAME, CLIENTPHONE, CLIENTADDRESS, CLIENTBIRTH, CLIENTHOBBY, CLIENTGENDER) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, c.getClientNo());
            pstmt.setString(2, c.getClientName());
            pstmt.setString(3, c.getClientPhone());
            pstmt.setString(4, c.getClientAddress());
            pstmt.setDate(5, c.getClientBirth());
            pstmt.setString(6, c.getClientHobby());
            pstmt.setString(7, c.getClientGender());
            pstmt.executeUpdate();
            System.out.println("성공 : 고객 정보가 등록되었습니다.");
        } catch (Exception e) {
            System.out.println("고객 등록 실패");
            e.printStackTrace();
        }
    }

    public void selectClient() {
        String sql = "SELECT * FROM CLIENT ORDER BY CLIENTNO";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n********************");
            System.out.println("고객 정보 조회");
            System.out.println("********************");

            while (rs.next()) {
                System.out.println("고객번호 : " + rs.getString("CLIENTNO"));
                System.out.println("고객명 : " + rs.getString("CLIENTNAME"));
                System.out.println("전화번호 : " + rs.getString("CLIENTPHONE"));
                System.out.println("주소 : " + rs.getString("CLIENTADDRESS"));
                System.out.println("생년월일 : " + rs.getDate("CLIENTBIRTH"));
                System.out.println("취미 : " + rs.getString("CLIENTHOBBY"));
                System.out.println("성별 : " + rs.getString("CLIENTGENDER"));
                System.out.println("--------------------");
            }
        } catch (Exception e) {
            System.out.println("고객 조회 실패");
            e.printStackTrace();
        }
    }

    public void updateClient(Client c) {
        String sql = "UPDATE CLIENT SET CLIENTNAME=?, CLIENTPHONE=?, CLIENTADDRESS=?, CLIENTBIRTH=?, CLIENTHOBBY=?, CLIENTGENDER=? WHERE CLIENTNO=?";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, c.getClientName());
            pstmt.setString(2, c.getClientPhone());
            pstmt.setString(3, c.getClientAddress());
            pstmt.setDate(4, c.getClientBirth());
            pstmt.setString(5, c.getClientHobby());
            pstmt.setString(6, c.getClientGender());
            pstmt.setString(7, c.getClientNo());

            if (pstmt.executeUpdate() > 0)
                System.out.println("성공 : 고객 정보가 수정되었습니다.");
            else
                System.out.println("해당 고객이 없습니다.");
        } catch (Exception e) {
            System.out.println("고객 수정 실패");
            e.printStackTrace();
        }
    }

    public void deleteClient(String clientNo) {
        String sql = "DELETE FROM CLIENT WHERE CLIENTNO=?";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, clientNo);

            if (pstmt.executeUpdate() > 0)
                System.out.println("성공 : 고객 정보가 삭제되었습니다.");
            else
                System.out.println("해당 고객이 없습니다.");
        } catch (Exception e) {
            System.out.println("고객 삭제 실패");
            e.printStackTrace();
        }
    }

    public boolean login(String clientNo) {
        String sql = "SELECT CLIENTNAME FROM CLIENT WHERE CLIENTNO=?";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, clientNo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("로그인 성공");
                    System.out.println(rs.getString("CLIENTNAME") + "님 환영합니다.");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("로그인 실패");
            e.printStackTrace();
        }

        System.out.println("로그인 실패 : 고객번호를 확인하세요.");
        return false;
    }
}
