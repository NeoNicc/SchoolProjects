//represents a dvd in the library
public class DVD extends LibraryItem {
	public String director;
	public int duration;
	
	public DVD(String title, String creator, int itemId, String director, int duration) {
		this.title = title;
		this.creator = creator;
		this.itemId = itemId;
		this.director = director;
		this.duration = duration;
	}
}
