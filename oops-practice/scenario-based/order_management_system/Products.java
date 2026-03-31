package order_management_system;
import java.util.List;
import java.util.ArrayList;
public class Products {
	private int productId;
	private String productName;
	private int quantity;
	private double price;
	public List<Products> product;
	
	Products(int productId,String productName,int quantity,double price){
		this.productId=productId;
		this.productName=productName;
		this.quantity=quantity;
		this.price=price;
		this.product = new ArrayList<>(); 
	}
	
	public int getPId() {
		return productId;
	}
	
	public String getPName() {
		return productName;
	}
	
	public int getPQuantity() {
		return quantity;
	}
	
	public double getPPrice() {
		return price;
	}
	
	public void setQuantity(int quan) {
		this.quantity=quan;
	}
	
	public void addPro(Products p) {
		product.add(p);
	}
	
	public void deletePro(Products p) {
		product.remove(p);
	}
	
	public void updateQuantity(Products p,int addQ) {
		p.quantity=addQ;
	}
	
	public void displayProduct() {
		System.out.println("Id\tName\t\tQuantity\t\tPrice");
		for(Products p:product) {
			System.out.println(p.productId+"\t"+p.productName+"\t\t"+p.quantity+"\t\t"+p.price);
		}
		System.out.println("----------------------------------------------------");
	}
}
