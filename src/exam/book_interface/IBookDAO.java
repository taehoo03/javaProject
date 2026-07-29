package exam.book_interface;

import java.util.ArrayList;

public interface IBookDAO {

	// 추가
	public void insertBook(BookDTO dto);

	// 삭제
	public void deleteBook(BookDTO dto);

	// 수정
	public void updateBook(BookDTO dto);

	// 조회
	public void searchBook(BookDTO dto);

	// 대출
	public void borrowBook(BookDTO dto);

	// 반납
	public void receiveBook(BookDTO dto);

	// 전체 조회
	public ArrayList<BookDTO> getAllBook();
}