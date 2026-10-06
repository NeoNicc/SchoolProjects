//represents a library and its items and members
public class Library {
	public LibraryItem[] items = new LibraryItem[25];
	public LibraryMember[] members = new LibraryMember[25];
	
	//add items to library
	public void addItem(LibraryItem item) {
		for (int i=0; i<items.length; i++) {
			if (items[i] == null) {
				items[i] = item;
				break;
			}
		}
	}
	
	//add members to library
	public void addMember(LibraryMember member) {
		for (int i=0; i<members.length; i++) {
			if (members[i] == null) {
				members[i] = member;
				break;
			}
		}
	}
	
	//override
	//counts actual members and items contained within library
	public String toString() {
		//counters necessary because array have predetermined lengths
		int itemCount = 0;
		int memberCount = 0;
		
		for (int i=0; i<items.length; i++) {
			if (items[i] != null) {
				itemCount += 1;
			}
		}
		
		for (int i=0; i<members.length; i++) {
			if (members[i] != null) {
				memberCount += 1;
			}
		}
		
		return "Library: Items - " + itemCount + ". Members - " + memberCount;
	}
}
