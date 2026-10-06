/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 01/26/26
	Assignment: 2.3.1 Lab
	Instructor: Sergio Pisano
	Description: Using Math Methods
 */
import java.util.Scanner;
public class LabProgram {

	public static void main(String[] args) {
		//scanner for inputs
		Scanner scnr = new Scanner(System.in);
		
		//declarations
		double x;
		double y;
		double z;
		//my declaration additions
		double expression1;
		double expression2;
		double expression3;
		double expression4;
		
		//retrieve input for x, y, and z
		x = scnr.nextDouble();
		y = scnr.nextDouble();
		z = scnr.nextDouble();
		
		//holds the expressions we want to output
		//for readability
		expression1 = Math.pow(x, z);
		expression2 = Math.pow(x, Math.pow(y, z));
		expression3 = Math.abs(y);
		expression4 = Math.sqrt(Math.pow(x * y,  z));
		
		//output the expressions in a
		//particular format
		System.out.print(expression1 + " ");
		System.out.print(expression2 + " ");
		System.out.print(expression3 + " ");
		System.out.println(expression4);
		
		//best practice
		scnr.close();
		System.exit(0);
	}

}

/*
 * Sample Output:
3.6
4.5
2.0
12.96 1.841304610218211e+11 4.5 16.2

 */