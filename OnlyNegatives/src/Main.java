/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 04/11/26
	Assignment: Module 6 Lab(LM) 2
	Instructor: Sergio Pisano
	Description: lists negative numbers
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      final int NUM_ELEMENTS = 6;
      Scanner scnr = new Scanner(System.in);
      ArrayList<Integer> listInts = new ArrayList<Integer>();
      // Hint: Declare listNegInts
      int i;

      // Get input integers
      for (i = 0; i < NUM_ELEMENTS; ++i) {
         listInts.add(scnr.nextInt());
      }

      /* Type your code here. */
      ArrayList<Integer> listNegInts = new ArrayList<Integer>();
      
      for (int num : listInts) {
    	  if (num < 0) {
    		  listNegInts.add(num);
    	  }
      }
      
      System.out.println(listNegInts.size() + "");
      
      for (int num : listNegInts) {
    	  System.out.println(num);
      }
      scnr.close();
   }
}

//Output
/*
 IN -> -1 0 8 10 -11 12
2
-1
-11

 */
