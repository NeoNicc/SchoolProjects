//Author: Nicholas Watson
//Date: 10/12/2026
//Class: COP 3337
//Program: validates a date entry in MM/DD/YYYY and converts it to DD Month, Year format
import java.util.Scanner;

public class ValiDate {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		
		String formattedDate = "";
		
		//sentinel value to end loop
		boolean validated = false;
		
		//input validation loop
		while (!validated) {
			int month = 0;
			int day = 0;
			int year = 0;
			
			try {
				System.out.println("Enter date in MM/DD/YYYY format: ");
				
				String dateInput = scnr.nextLine();
				
				String[] separatedDate = dateInput.split("/");
				if (separatedDate.length != 3) {
					throw new ArrayIndexOutOfBoundsException("Incorrect Format, try again.");
				}
				
				//assign numbers to their variable
				//check that input can be parsed to integers
				month = Integer.parseInt(separatedDate[0]);
				day = Integer.parseInt(separatedDate[1]);
				year = Integer.parseInt(separatedDate[2]);
				
				//check that dates are within bounds
				if (month < 1 || month > 12) {
					throw new MonthException();
				}
				
				if (year < 1000 || year > 3000) {
					throw new YearException();
				}
				
				switch (month) {
				case 1, 3, 5, 7, 8, 10, 12:
					if (day < 0 || day > 31) {
						throw new DayException(month, year);
					}
				
					break;
				case 4, 6, 9, 11:
					if (day < 0 || day > 30) {
						throw new DayException(month, year);
					}
			
					break;
				case 2:
					//leap year vvv
					if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
						if (day < 0 || day > 29) {
							throw new DayException(month, year);
						}
						
					} else { //not leap year vvv
						if (day < 0 || day > 28) {
							throw new DayException(month, year);
						}
					}
					break;
				}
	
				//update sentinel value to end loop
				validated = true;
				
				//switch statement to reformat date
				switch (month) {
				case 1:
					formattedDate += "January " + day + ", " + year;
					break;
				case 2:
					formattedDate += "February " + day + ", " + year;
					break;
				case 3:
					formattedDate += "March " + day + ", " + year;
					break;
				case 4:
					formattedDate += "April " + day + ", " + year;
					break;
				case 5:
					formattedDate += "May " + day + ", " + year;
					break;
				case 6:
					formattedDate += "June " + day + ", " + year;
					break;
				case 7:
					formattedDate += "July " + day + ", " + year;
					break;
				case 8:
					formattedDate += "August " + day + ", " + year;
					break;
				case 9:
					formattedDate += "September " + day + ", " + year;
					break;
				case 10:
					formattedDate += "October " + day + ", " + year;
					break;
				case 11:
					formattedDate += "November " + day + ", " + year;
					break;
				case 12:
					formattedDate += "December " + day + ", " + year;
					break;
				}
				
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect format. Please use MM/DD/YYYY format.");
			} catch (MonthException e) {
				System.out.println(e.getMessage());
			} catch (YearException e) {
				System.out.println(e.getMessage());
			} catch (DayException e) {
				System.out.println(e.getMessage());
			}
		}
		scnr.close();
		//input validation loop end
		
		System.out.println("Formatted Date: " + formattedDate);
	}

}
