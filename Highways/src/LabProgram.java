/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 03/01/26
	Assignment: Module 4 Lab(LM)
	Instructor: Sergio Pisano
	Description: Determines Highway type and direction
 */
import java.util.Scanner; 

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in); 
      int highwayNumber;
      int primaryNumber;

      highwayNumber = scnr.nextInt();
      
      //to determine primary or auxiliary
      boolean isPrimary = false;
      boolean isVertical = false;

      //checks first if the number is valid, then
      //assigns primary status or grabs the first 2 digits in the number 
      if ((!(highwayNumber / 100 < 1) || !(highwayNumber % 100 == 0)) && (Math.log10(highwayNumber) < 4)) {
    	  if ((Math.log10(highwayNumber) + 1) < 3) {
    		  primaryNumber = highwayNumber;
    		  isPrimary = true;
    	  } else {
    		  primaryNumber = highwayNumber % 100;
    	  }
      } else {
    	  primaryNumber = 0;
      }
      
      if ((primaryNumber != 0) && (primaryNumber % 2 != 0)) {
    	  isVertical = true;
      }
      
      System.out.println(constructPhrase(highwayNumber, primaryNumber, isPrimary, isVertical));
      scnr.close();
   }
   
   public static String constructPhrase(int highwayNum, int primaryNum, boolean isP, boolean isV) {
	   String phrase = "";
	   
	   if (primaryNum == 0) {
		   phrase += highwayNum + " is not a valid interstate highway number.";
		   return phrase;
	   }
	   
	   if (isP == true) {
		   phrase += "I-" + highwayNum + " is primary,";
	   } else {
		   phrase += "I-" + highwayNum + " is auxiliary, serving I-" + primaryNum + ",";
	   }
	   if (isV == true) {
		   phrase += " going north/south.";
	   } else {
		   phrase += " going east/west.";
	   }
	   
	   return phrase;
   }
}

/*
190
I-190 is auxiliary, serving I-90, going east/west.
*/