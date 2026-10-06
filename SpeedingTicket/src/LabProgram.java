/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 03/01/26
	Assignment: Module 4 Lab(LM)
	Instructor: Sergio Pisano
	Description: Determines Speeding Ticket Amount
 */

import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      int speedLimit = scnr.nextInt();
      int driverSpeed = scnr.nextInt();
      
      System.out.println(calculateTicket(speedLimit, driverSpeed));
      scnr.close();
   }
   public static int calculateTicket(int limit, int dSpeed) {
	   int ticketAmount = 0;
	   
	   if (limit - dSpeed > 9) {
		   ticketAmount = 50;
	   } else if ((dSpeed - limit > 5) && (dSpeed - limit < 21)) {
		   ticketAmount = 75;
	   } else if ((dSpeed - limit > 20) && (dSpeed - limit < 41)) {
		   ticketAmount = 150;
	   } else if (dSpeed - limit > 40) {
		   ticketAmount = 300;
	   }
	   return ticketAmount;
   }
}