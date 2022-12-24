package models;

public class Items
{
	public String product_name;
	public Double price;
	public int quantity;
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Items(String product_name, Double price, int quantity) 
	{
		
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Items [product_name=" + product_name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
