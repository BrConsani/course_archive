package entities;

public class Product {
	
	private String name;
	private float price;
	private int quantity;
	
	//CONSTRUCTORS
	public Product(String name, float price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getUnitPrice() {
		return price;
	}
	
	public void setUnitPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getFinalPrice() {
		return price*quantity;
	}
	
	//FUNCTIONS
	public String toStringFinal() {
		return name+","+this.getFinalPrice();
	}
	
	public String toStringInit() {
		return name+","+price+","+quantity;
	}

}
