package BookShopV4;

public class Book {
	String name = "" ;
	String ID	= "";
	double price= 0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void showInfo() {
		System.out.println("Name \t\t:" + this.name);
		System.out.println("ID \t\t:" + this.ID);
		System.out.println("Price \t\t:" + this.price);
	}
	
	public Book() {
		
	}
	
	public Book(String name, String ID, double price) {
		this.name = name;
		this.ID = ID;
		this.price = price;
	}
}
