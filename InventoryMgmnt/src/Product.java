//class for generic products
//parent to electrons and furniture
//includes a builder class
//to reduce complexity from 
//multiple overloaded constructors 

public class Product {
	private int productId;
	private String name;
	private double price;
	private int quantity;
	
	//nested static abstract class for encapsulation
	public static abstract class AbstractBuilder<T extends AbstractBuilder<T>> {
		private int productId = 0;
		private String name = "";
		private double price = 0.0;
		private int quantity = 0;
		
		public T productId(int productId) {
			if (productId >= 0) this.productId = productId;
			return self();
		}
		
		public T name(String name) {
			if (name != null) this.name = name;
			return self();
		}
		
		public T price(double price) {
			if (price >= 0.0) this.price = price;
			return self();
		}
		
		public T quantity(int quantity) {
			if (quantity >= 0) this.quantity = quantity;
			return self();
		}
		
		//to be overridden but subclasses for corrected typing
		protected abstract T self();
		
		//method to build the item
		public Product build() {
			return new Product(this);
		}
	}
	
	public static class Builder extends AbstractBuilder<Builder> {
		@Override
		protected Builder self() {
			return this;
		}
	}
	
	//constructor that calls the builder to 
	//help with construction
	protected Product(AbstractBuilder<?> builder) {
		this.productId = builder.productId;
		this.name = builder.name;
		this.price = builder.price;
		this.quantity = builder.quantity;
	}
	
	//getters (accessors)
	public int getProductId() { return productId; }
	public String getName() { return name; }
	public double getPrice() { return price; }
	public int getQuantity() { return quantity; }
	
	//setters (mutators)
	public void setProductId(int id) {
		if (id >= 0) this.productId = id;
	}
	
	public void setName(String name) {
		if (name != null) this.name = name;
	}
	
	public void setPrice(double price) {
		if (price >= 0.0) this.price = price;
	}
	
	public void setQuantity(int quantity) {
		if (quantity >= 0) this.quantity = quantity;
	}
	
	//method for calculating products total value
	public double calculateTotalValue() {
		return price * quantity;
	}
	
	//re-stock method for increasing item quantity
	public void restock(int amount) {
		System.out.println("Restocking by " + amount + " units...");
		if (amount >= 0) this.quantity += amount;
	}
	
	//toString for verbose details
	@Override
	public String toString() {
		return String.format("Product ID: %d\nProduct Name: %s\nPrice: $%.2f\nQuantity: %d", productId, name, price, quantity);
	}
}
