
public class Slicer {
	private String slicedText;
	private String fullContent;
	private String beginning;
	private String end;
	
	public Slicer(String fullContent, String beginning, String end) {
		this.fullContent = fullContent;
		this.beginning = beginning;
		this.end = end;
		
		int beginningIndex = this.fullContent.indexOf(beginning);
		int endIndex = this.fullContent.indexOf(end);
		
		slicedText = fullContent.substring(beginningIndex, (endIndex + end.length()));
	}
	
	public String getSlicedText() {
		return slicedText;
	}
}
