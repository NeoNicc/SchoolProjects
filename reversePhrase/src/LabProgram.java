/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 03/29/26
	Assignment: Module 5 Lab 3
	Instructor: Sergio Pisano
	Description: output a words or phrases in reverse
 */

import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
	   //initialize the scanner for new inputs
	   Scanner scnr = new Scanner(System.in);
	   
	   //get all the inputs to be reversed
       String allPhrases = getEm(scnr);
       
       //reverses and prints those inputs
       reverseEm(allPhrases);
   }
   
   //creates a String of all phrases entered
   public static String getEm(Scanner scnr) {
	   boolean continuing = true;
	   
	   String allPhrases = "";
	   
	   while(continuing) {
		   if (!continuing) {
			   break;
		   } else {
			   String phrase = scnr.nextLine();
			   if (phrase.equals("d") == true || phrase.toLowerCase().equals("done") == true) {
				   continuing = false;
			   } else {
				   allPhrases += phrase + " -- ";
			   }
		   }
	   }
	   
	   return allPhrases;
   }
   
   //method for reversing the words or phrases.
   public static void reverseEm(String allPhrases) {
	   //creates an array of the individual inputs
	   String[] phraseSets = allPhrases.split(" -- ");
	   
	   //initializes the variables for the reversed
	   //versions of the inputs
	   String reversedPhrases = "";
	   String[] reversedPhraseSet;
	   
	   //reverses the phraseSets and 
	   //places them into a reversed String to print
	   for (String phrase : phraseSets) {
		   for (int i = phrase.length() - 1; i >= 0; i--) {
			   reversedPhrases += phrase.charAt(i);
		   }
		   reversedPhrases += " -- ";
	   }
	   
	   reversedPhraseSet = reversedPhrases.split(" -- ");
	   
	   for (int i = 0; i < reversedPhraseSet.length; i++) {
		   System.out.println(reversedPhraseSet[i]);
	   }
   }
}
//Output
/*
	hello
	i hope this
	reverses
	done
	olleh
	siht epoh i
	sesrever
 */