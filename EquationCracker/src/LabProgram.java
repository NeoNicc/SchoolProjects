/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 03/25/26
	Assignment: Module 5 Lab 2
	Instructor: Sergio Pisano
	Description: use brute force method to solve 2 linear equations
 */

import java.util.Scanner; 

public class LabProgram {
   public static void main(String[] args) {
	  //initialize scanner for input
	  Scanner scnr = new Scanner(System.in);
	   
	  //get input for the two equations
      int[] firstEquation = getEquation(scnr);
      int[] secondEquation = getEquation(scnr);
      
      //solve for the variables in each equation
      int[] solved = solveEquations(firstEquation, secondEquation);
      
      //check if solutions match
      doesMatch(solved);
   }
   
   //get input for 2 coefficients and a solution
   public static int[] getEquation(Scanner scnr) {
	   int coefficient1 = scnr.nextInt();
	   int coefficient2 = scnr.nextInt();
	   int constant = scnr.nextInt();
	   
	   int[] equation = {coefficient1, coefficient2, constant};
	   return equation;
   }
   
   //attempt to solve a linear equation using
   //Brute force
   public static int[] solveEquations(int[] equation1, int[] equation2) {
	   boolean solved = false;
	   
	   //variables to solve for
	   int x = -11;
	   int y = -11;
	   
	   //nested loop to test every possible solution
	   //aka brute force technique
	   for (int a = -10; a < 10; a++) {
		   for (int b = -10; b < 11; b++) {
			   if (equation1[0] * a + equation1[1] * b == equation1[2] && equation2[0] * a + equation2[1] * b == equation2[2]) {
				   solved = true;
				   x = a;
				   y = b;
			   }
		   }
	   }
	   
	   //returns resulting solution if it exists
	   //otherwise an indicator of failure
	   if (solved == true) {
		   int[] solution = {x, y};
		   return solution;
	   } else {
		   int[] failure = {0};
		   return failure;
	   }
   }
   
   //check if equations had matching solution
   //print result
   public static void doesMatch(int[] equation) {
	   if (equation.length == 1) {
		   System.out.println("There is no solution");
	   } else {
		   System.out.println("x = " + equation[0] + ", y = " + equation[1]);
	   }
   }
}

//Output
/*
	8 7 38
	3 -5 -1
	x = 3, y = 2
*/