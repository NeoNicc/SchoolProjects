//custom exception for incorrect year
public class YearException extends Exception {

	public YearException() {
		super("Invalid year. Please enter a number between 1000 and 3000.");
	}

	public YearException(String message) {
		super(message);
	}
}
