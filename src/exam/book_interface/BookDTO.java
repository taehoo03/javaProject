package exam.book_interface;

public class BookDTO {
	private int BookCode;
	private String UserName;
	private String StartDate;
	private String EndDate;
	
	
	
	public BookDTO(int BookCode,String UserName,String StartDate,String EndDate){
		this.BookCode =BookCode;
		this.UserName =UserName;
		this.StartDate =StartDate;
		this.EndDate =EndDate;
	}



	public int getBookCode() {
		return BookCode;
	}



	public void setBookCode(int bookCode) {
		BookCode = bookCode;
	}



	public String getUserName() {
		return UserName;
	}



	public void setUserName(String userName) {
		UserName = userName;
	}



	public String getStartDate() {
		return StartDate;
	}



	public void setStartDate(String startDate) {
		StartDate = startDate;
	}



	public String getEndDate() {
		return EndDate;
	}



	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
}
