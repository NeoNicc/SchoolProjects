/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 02/07/26
	Assignment: Module 3 lab 1
	Instructor: Sergio Pisano
	Description: Cost of miles driven
 */

import java.util.Scanner;

public class LabProgram {
	//method for calculating cost
   public static double drivingCost(double milesPerGallon, double dollarsPerGallon, double milesDriven) {
	   double totalCost = (milesDriven / milesPerGallon) * dollarsPerGallon;
	   
	   return totalCost;
   }
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      double carMPG = -1;
      double gasPrice = -1;
      
      carMPG = scnr.nextDouble();
      gasPrice = scnr.nextDouble();
      
      System.out.printf("%.2f ", drivingCost(carMPG, gasPrice, 10)); //Cost for 10 miles
      System.out.printf("%.2f ", drivingCost(carMPG, gasPrice, 50)); //Cost for 50 miles
      System.out.printf("%.2f\n", drivingCost(carMPG, gasPrice, 400)); //Cost for 400 miles
      scnr.close();
   }
}
/*Output:
20.0 -in
3.1599 -in
1.58 7.90 63.20 -out
*/