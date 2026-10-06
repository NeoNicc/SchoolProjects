/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 01/26/26
	Assignment: 2.3.1 Lab (H)
	Instructor: Sergio Pisano
	Description: expression for calories burned
 */
import java.util.Scanner;
public class LabProgram {

	public static void main(String[] args) {
		//scanner for input
		Scanner scnr = new Scanner(System.in);
		
		//declarations
		double age;
		double weight;
		double heartRate;
		double time;
		double expression;
		
		//gather inputs
		age = scnr.nextDouble();
		weight = scnr.nextDouble();
		heartRate = scnr.nextDouble();
		time = scnr.nextDouble();
		
		//instantiate the expression
		expression = (((age * 0.2757) + (weight * 0.03295) + (heartRate * 1.0781)) - 75.4991) * (time / 8.368);
		
		//output
		System.out.print("Calories: ");
		System.out.printf("%.2f", expression);
		System.out.println(" calories");
		scnr.close();
	}

}
/*
 * Output
49
155
148
60
Calories: 736.21 calories
 */