package exam.binding;

public class ProductVo {

    private int productNo;
    private String productName;
    private int price;
    private String company;
    private String description;

    public ProductVo() {
    }

    public ProductVo(int productNo, String productName, int price,
                     String company, String description) {
        this.productNo = productNo;
        this.productName = productName;
        this.price = price;
        this.company = company;
        this.description = description;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}