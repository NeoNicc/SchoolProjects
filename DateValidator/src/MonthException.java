//custom exception for incorrect month
public class MonthException extends Exception {

	public MonthException() {
		super("Invalid month. Please enter a number between 1 and 12.");
	}

	public MonthException(String message) {
		super(message);
	}
}
