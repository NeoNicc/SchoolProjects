//custom exception for incorrect day
public class DayException extends Exception {
	
	//includes 2 params for month and year
	//params used by helper function to determine
	//the correct number of days
	public DayException(int month, int year) {
		super(getMessage(month, year));
	}

	public DayException(String message) {
		super(message);
	}
	
	//helper method to declare correct number of days depending on month and year
	private static String getMessage(int month, int year) {
		String message = "";
		
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12:
			message = "Invalid day. Please enter a number between 1 and 31.";
			break;
		case 4, 6, 9, 11:
			message = "Invalid day. Please enter a number between 1 and 30.";
			break;
		case 2:
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				message = "Invalid day. Please enter a number between 1 and 29.";
			} else {
				message = "Invalid day. Please enter a number between 1 and 28.";
			}
			break;
		}
		return message;	
	}
}
