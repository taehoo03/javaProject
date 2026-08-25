package exam.stockmanager;

public class Product implements Comparable<Product> {

	private String productName;
	private int productStock;

	public Product(String productName) {
		this(productName, 0);
	}

	public Product(String productName, int productStock) {
		this.productName = productName;
		this.productStock = productStock;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public int getProduct(int num) {

		if (num > productStock) {
			return -1;
		}

		productStock -= num;

		return productStock;
	}

	@Override
	public int compareTo(Product o) {

		return productName.compareTo(
				o.productName);
	}

	@Override
	public String toString() {

		return productName + " : "
				+ productStock;
	}
}