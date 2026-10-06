//represents a book in the library
public class Book extends LibraryItem {
	private String genre;
	private int numberOfPages;
	
	Book(String title, String creator, int itemId, String genre, int numberOfPages) {
		this.title = title;
		this.creator = creator;
		this.itemId = itemId;
		this.genre = genre;
		this.numberOfPages = numberOfPages;
	}
}
