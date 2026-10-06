/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 02/08/26
	Assignment: Module 3 Lab(H)
	Instructor: Sergio Pisano
	Description: Prints Items in a Shopping Cart
 */
public class ItemToPurchase {
	private String itemName;
	private int itemPrice;
	private int itemQuantity;
	
	//Constructor
	ItemToPurchase() {
		this.itemName = "none";
		this.itemPrice = 0;
		this.itemQuantity = 0;
	}
	
	//getter and setter methods grouped by field
	public void setName(String name) {
		this.itemName = name;
	}
	public String getName() {
		return this.itemName;
	}
	
	public void setPrice(int price) {
		this.itemPrice = price;
	}
	public int getPrice() {
		return this.itemPrice;
	}
	
	public void setQuantity(int quantity) {
		this.itemQuantity = quantity;
	}
	public int getQuantity() {
		return this.itemQuantity;
	}
}
/*Output
Item1
Enter the item name:
Chocolate Chips
Enter the item price:
3
Enter the item quantity:
1
Item2
Enter the item name:
Bottled Water
Enter the item price:
1
Enter the item quantity:
10
TOTAL COST
Chocolate Chips 1 @ $3 = $3
Bottled Water 10 @ $1 = $10

Total: $13

 */