/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 03/25/26
	Assignment: Module 5 Lab 1
	Instructor: Sergio Pisano
	Description: count # of characters in a String
 */

import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
	  Scanner scnr = new Scanner(System.in);
	  
	  String charInput = scnr.next();
	  String phrase = scnr.nextLine();
	  
	  char checkedChar = charInput.charAt(0);
	  //runs our scanWord function below
	  //to check for matched characters
      scanWord(checkedChar, phrase);
      scnr.close();
   }
   
   public static void scanWord(char checkedCharacter, String phrase) {
	   int matchCount = 0;
	   
	   //loop to iterate each character of the phrase string
	   //to check for matches
	   for (int i = 0; i < phrase.length(); i++) {
		   if (phrase.charAt(i) == checkedCharacter) {
			   matchCount += 1;
		   }
	   }
	   if (matchCount == 1) {
		   System.out.println(matchCount + " " + checkedCharacter);
	   } else {
		   System.out.println(matchCount + " " + checkedCharacter + "'s");
	   }
   }
}
//Output
/*
 * b bobby bakes
 * 4 b's
*/