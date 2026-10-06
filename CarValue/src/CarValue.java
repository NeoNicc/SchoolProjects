/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 02/07/26
	Assignment: Module 3 lab 2
	Instructor: Sergio Pisano
	Description: determine car value
 */
import java.util.Scanner;

public class CarValue {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Car myCar = new Car();

      int userYear = scnr.nextInt();
      int userPrice = scnr.nextInt();
      int userCurrentYear = scnr.nextInt();

      myCar.setModelYear(userYear);
      myCar.setPurchasePrice(userPrice);
      myCar.calcCurrentValue(userCurrentYear);

      myCar.printInfo();
      scnr.close();
   }
}