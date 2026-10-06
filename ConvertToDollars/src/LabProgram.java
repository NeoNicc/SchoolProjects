/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 01/26/26
	Assignment: 2.3.1
	Instructor: Sergio Pisano
	Description: Converting Chage to dollars
 */
import java.util.Scanner;

public class LabProgram {

	public static void main(String[] args) {
		//open the scanner to be used for input
				Scanner scnr = new Scanner(System.in);
				
				//declarations
				float nickels;
				float dimes;
				float quarters;
				float totalChange;
				
				//initialize the nickels, dimes, and
				//quarters with a prompt before each is calculated
				//and saved to memory
				
				//prompt
				//System.out.println("How many nickels have ya got?");
				
				//this converts the number entered by
				//multiplying by the change value 
				//shifting the decimal 2 spaces and
				//showing it's value in dollars
				nickels = (scnr.nextFloat() * (float)0.05);
				
				//System.out.println("How many dimes, then?");
				dimes = (scnr.nextFloat() * (float)0.1);
				
				//System.out.println("Best to count the quarters too.");
				quarters = (scnr.nextFloat() * (float)0.25);
				
				//the total dollar value of the combined 
				//converted totals of the change
				totalChange = nickels + dimes + quarters;
				
				//output for our newly converted value
				System.out.print("Amount: $");
				//formatting the output for consistency
				System.out.printf("%.2f\n", totalChange);
				
				//best practice scanner close
				scnr.close();
				
				System.exit(0);

	}

}
/* 
 * OUTPUT:
 	How many nickels have ya got?
	3
	How many dimes, then?
	5
	Best to count the quarters too.
	2
	Amount: $1.15
 */
