/*
HEADER COMMENT BLOCK
Author: Nicholas Watson
Course: COP2250-2210.
Date: 1/26/26
Assignment: Discussion Module 2
Instructor: Sergio Pisano.
Description: This program calculates hourly wages plus 
overtime.
 */

public class Driver
{
	public static void main(String[] args)       
	{	
		double basePay = 15; // Base pay rate in $
		double regularHours = 8; // Hours worked by employee (less overtime)
		double overtimeHours = 3; // Overtime hours worked
		double totalHours = regularHours + overtimeHours;
		
		double overtimeWages; // Overtime wages total calculation
		double regularWages; // Regular wages total calculation
		double totalWages; // Addition of regular wages and overtime wages
		double totalWagesPerHour; // total of regular and overtime income hourly pay

		//Calculation of regular wages total
		regularWages = basePay * regularHours;

		// Calculate the overtime wages.
		overtimeWages = (basePay * 1.5) * overtimeHours;

		// Calculate the total wages.
		totalWages = regularWages + overtimeWages;
		
		// Calculate the total wages per hour
		totalWagesPerHour = totalWages / totalHours;

		// Display value for average paid per hour.
		// ENTER YOUR CODE HERE:
		System.out.print("Daily Wages: $");
		System.out.printf("%.2f\n", totalWages);
		System.out.print("Total wages per hour: $");
		System.out.printf("%.2f\n", totalWagesPerHour);

	}
}  
/* CODE OUTPUT:
 *  Daily Wages: $187.50
	Total wages per hour: $17.05

 */