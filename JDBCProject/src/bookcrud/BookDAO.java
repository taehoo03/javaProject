package bookcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {
    private DBConn db = new DBConn();

    public void insertBook(Book book) {
        String sql = "INSERT INTO BOOK (BOOKNO, BOOKNAME, BOOKAUTHOR, BOOKPRICE, BOOKDATE, BOOKSTOCK, PUBNO) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, book.getBookNo());
            pstmt.setString(2, book.getBookName());
            pstmt.setString(3, book.getBookAuthor());
            pstmt.setInt(4, book.getBookPrice());
            pstmt.setDate(5, book.getBookDate());
            pstmt.setInt(6, book.getBookStock());
            pstmt.setString(7, book.getPubNo());

            pstmt.executeUpdate();
            System.out.println("성공 : 도서 정보가 등록되었습니다.");

        } catch (Exception e) {
            System.out.println("도서 등록 실패");
            e.printStackTrace();
        }
    }

    public void selectBook() {
        String sql = "SELECT * FROM BOOK ORDER BY BOOKNO";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n********************");
            System.out.println("도서 정보 조회");
            System.out.println("********************");

            while (rs.next()) {
                System.out.println("도서번호 : " + rs.getInt("BOOKNO"));
                System.out.println("도서명 : " + rs.getString("BOOKNAME"));
                System.out.println("저자 : " + rs.getString("BOOKAUTHOR"));
                System.out.println("가격 : " + rs.getInt("BOOKPRICE"));
                System.out.println("발행일 : " + rs.getDate("BOOKDATE"));
                System.out.println("재고 : " + rs.getInt("BOOKSTOCK"));
                System.out.println("출판사 번호 : " + rs.getString("PUBNO"));
                System.out.println("--------------------");
            }

        } catch (Exception e) {
            System.out.println("도서 조회 실패");
            e.printStackTrace();
        }
    }

    public void updateBook(Book book) {
        String sql = "UPDATE BOOK SET BOOKNAME=?, BOOKAUTHOR=?, BOOKPRICE=?, BOOKDATE=?, BOOKSTOCK=?, PUBNO=? WHERE BOOKNO=?";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, book.getBookName());
            pstmt.setString(2, book.getBookAuthor());
            pstmt.setInt(3, book.getBookPrice());
            pstmt.setDate(4, book.getBookDate());
            pstmt.setInt(5, book.getBookStock());
            pstmt.setString(6, book.getPubNo());
            pstmt.setInt(7, book.getBookNo());

            if (pstmt.executeUpdate() > 0)
                System.out.println("성공 : 도서 정보가 수정되었습니다.");
            else
                System.out.println("해당 도서가 없습니다.");

        } catch (Exception e) {
            System.out.println("도서 수정 실패");
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookNo) {
        String sql = "DELETE FROM BOOK WHERE BOOKNO=?";

        try (Connection con = db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, bookNo);

            if (pstmt.executeUpdate() > 0)
                System.out.println("성공 : 도서 정보가 삭제되었습니다.");
            else
                System.out.println("해당 도서가 없습니다.");

        } catch (Exception e) {
            System.out.println("도서 삭제 실패");
            e.printStackTrace();
        }
    }
}
