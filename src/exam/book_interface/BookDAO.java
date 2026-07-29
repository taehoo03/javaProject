package exam.book_interface;

import java.util.ArrayList;

public class BookDAO implements IBookDAO {

	@Override
	public void insertBook(BookDTO dto) {
		System.out.println(dto.getBookCode() + "번 도서를 추가했습니다.");
	}

	@Override
	public void deleteBook(BookDTO dto) {
		System.out.println(dto.getBookCode() + "번 도서를 삭제했습니다.");
	}

	@Override
	public void updateBook(BookDTO dto) {
		System.out.println(dto.getBookCode() + "번 도서를 수정했습니다.");
	}

	@Override
	public void searchBook(BookDTO dto) {
		System.out.println(dto.getBookCode() + "번 도서를 조회했습니다.");
	}

	@Override
	public void borrowBook(BookDTO dto) {
		System.out.println(dto.getUserName() + "님이 도서를 대출했습니다.");
	}

	@Override
	public void receiveBook(BookDTO dto) {
		System.out.println(dto.getUserName() + "님이 도서를 반납했습니다.");
	}

	@Override
	public ArrayList<BookDTO> getAllBook() {
		System.out.println("전체 도서를 조회합니다.");
		return new ArrayList<BookDTO>();
	}
}