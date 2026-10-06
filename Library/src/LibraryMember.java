//represents a member at the library and 
//offers methods to borrow and return library items
public class LibraryMember {
	public String name;
	public String address;
	public String contact;
	public int memberId;
	public LibraryItem[] borrowedItems = new LibraryItem[12];
	public double fines;
	
	LibraryMember(String name, String address, String contact, int memberId) {
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.memberId = memberId;
	}
	
	public void borrowItem(LibraryItem item) {
		for (int i=0; i<borrowedItems.length; i++) {
			if (borrowedItems[i] != null) {
				borrowedItems[i] = item;
			}
		}
	}
	
	public void returnItem(LibraryItem item) {
		for (int i=0; i<borrowedItems.length; i++) {
			if (item == borrowedItems[i]) {
				borrowedItems[i] = null;
			}
		}
	}
}
