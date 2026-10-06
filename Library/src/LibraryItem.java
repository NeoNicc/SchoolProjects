//generally represents an item contained within a library
public class LibraryItem {
	public String title;
	public String creator;
	public int itemId;
	public boolean available = true;
	
	public boolean checkoutItem() {
		if (isAvailable()) {
			System.out.println("Item checked out successfully.");
			available = false;
			return true;
		} else {
			System.out.println("Item is not available for borrowing.");
			return false;
		}
	}
	
	public boolean returnItem() {
		if (isAvailable()) {
			System.out.println("Item already returned.");
			return false;
		} else {
			available = true;
			System.out.println("Item returned successfully.");
			return true;
		}
	}
	
	public boolean isAvailable() {
		if (available == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getItemId() {
		return itemId;
	}
}
