package bookcrud;

import java.sql.Date;

public class BookSale {
    private String bsNo;
    private Date bsDate;
    private String bsQty;
    private String bookNo;
    private String clientNo;

    public BookSale() {}

    public BookSale(String bsNo, Date bsDate, String bsQty, String bookNo, String clientNo) {
        this.bsNo = bsNo;
        this.bsDate = bsDate;
        this.bsQty = bsQty;
        this.bookNo = bookNo;
        this.clientNo = clientNo;
    }

    public String getBsNo() { return bsNo; }
    public void setBsNo(String bsNo) { this.bsNo = bsNo; }

    public Date getBsDate() { return bsDate; }
    public void setBsDate(Date bsDate) { this.bsDate = bsDate; }

    public String getBsQty() { return bsQty; }
    public void setBsQty(String bsQty) { this.bsQty = bsQty; }

    public String getBookNo() { return bookNo; }
    public void setBookNo(String bookNo) { this.bookNo = bookNo; }

    public String getClientNo() { return clientNo; }
    public void setClientNo(String clientNo) { this.clientNo = clientNo; }
}
