package exam.book_interface;

public class BookMain {

	public static void main(String[] args) {

		BookDTO dto = new BookDTO(
				1001,
				"홍길동",
				"2026-07-29",
				"2026-08-05");

		IBookDAO dao = new BookDAO();

		dao.insertBook(dto);
		dao.searchBook(dto);
		dao.updateBook(dto);
		dao.borrowBook(dto);
		dao.receiveBook(dto);
		dao.deleteBook(dto);
		dao.getAllBook();
	}
}