/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 04/11/26
	Assignment: Module 6 Lab(H)
	Instructor: Sergio Pisano
	Description: Input and manipulate a soccer team roster
 */
import java.util.Scanner;

public class PlayerRoster {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      /* Type your code here. */
      final int PLAYERS = 5;
      
      int[] jerseyNums = new int[5];
      int[] ratings = new int[5];
      
      boolean running = true;
      
      //grab players info
	  for (int i = 0; i < PLAYERS; i++) {
		  System.out.println("Enter player " + (i+1) + "'s jersey number:");
		  jerseyNums[i] = scnr.nextInt();
		  
		  System.out.println("Enter player " + (i+1) + "'s rating:");
		  ratings[i] = scnr.nextInt();
		  
		  System.out.println();
	  }
	  //display roster
	  displayRoster(jerseyNums, ratings, 0);
	  
      while (running) {
    	  System.out.println(
			  "MENU\r\n"
	  		+ "u - Update player rating\r\n"
	  		+ "a - Output players above a rating\r\n"
	  		+ "r - Replace player\r\n"
	  		+ "o - Output roster\r\n"
	  		+ "q - Quit\r\n"
	  		+ "\r\n"
	  		+ "Choose an option:"
    	  );
    	  
    	  String userAction = scnr.next();
    	  
    	  switch (userAction) {
    	  	case "u":
    	  		System.out.println("Enter a jersey number:");
    	  		int jerseyInput = scnr.nextInt();
    	  		
    	  		for (int i = 0; i < jerseyNums.length; i++) {
    	  			if (jerseyNums[i] == jerseyInput) {
    	  				System.out.println("Enter a new rating for player:");
    	  				ratings[i] = scnr.nextInt();
    	  				break;
    	  			}
    	  		}
    		    break;
    	  	case "a":
    	  		System.out.println();
    	  		System.out.println("Enter a rating:");
    	  		int ratingInput = scnr.nextInt();
    	  		
    	  		System.out.println();
    	  		displayRoster(jerseyNums, ratings, ratingInput);
    	  		break;
    	  	case "r":
    	  		System.out.println("Enter a jersey number:");
    	  		int playerToReplace = scnr.nextInt();
    	  		for (int i = 0; i < jerseyNums.length; i++) {
    	  			if (jerseyNums[i] == playerToReplace) {
    	  				System.out.println("Enter a new jersey number:");
    	  				jerseyNums[i] = scnr.nextInt();
    	  				System.out.println("Enter a rating for the new player:");
    	  				ratings[i] = scnr.nextInt();
    	  				break;
    	  			}
    	  		}
    	  		break;
    	  	case "o":
    	  		displayRoster(jerseyNums, ratings, 0);
    	  		break;
    	  	case "q":
    	  		running = false;
    	  		break;
    	  	default:
    	  		System.out.println("Invalid entry");
    	  		break;
    	  }
      }
      scnr.close();
   }
   public static void displayRoster(int[] jerseys, int[] ratings, int min) {
	   if (min == 0) {
		   System.out.println("ROSTER");
	   } else {
		   System.out.println("ABOVE " + min);
	   }
	   
	   for (int i = 0; i < jerseys.length; i++) {
		   if (ratings[i] > min) {
			   System.out.println("Player " + (i+1) + " -- Jersey number: " + jerseys[i] + ", Rating: " + ratings[i]);
		   }
	   }
	   System.out.println();
   }
}

//Output
/*
Enter player 1's jersey number:
1
Enter player 1's rating:
1
Enter player 2's jersey number:
2
Enter player 2's rating:
2
Enter player 3's jersey number:
3
Enter player 3's rating:
3
Enter player 4's jersey number:
4
Enter player 4's rating:
4
Enter player 5's jersey number:
5
Enter player 5's rating:
5
ROSTER
Player 1 -- Jersey number: 1, Rating: 1
Player 2 -- Jersey number: 2, Rating: 2
Player 3 -- Jersey number: 3, Rating: 3
Player 4 -- Jersey number: 4, Rating: 4
Player 5 -- Jersey number: 5, Rating: 5
MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option: 
u
Enter a jersey number:
2
Enter a new rating for player:
6
MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option: 
a
Enter a rating:
4
Above 4
Player 2 -- Jersey number: 2, Rating: 6
Player 5 -- Jersey number: 5, Rating: 5
MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option: 
r
Enter a jersey number:
2
Enter a new jersey number:
88
Enter a rating for the new player:
8
MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option: 
o
ROSTER
Player 1 -- Jersey number: 1, Rating: 1
Player 2 -- Jersey number: 88, Rating: 8
Player 3 -- Jersey number: 3, Rating: 3
Player 4 -- Jersey number: 4, Rating: 4
Player 5 -- Jersey number: 5, Rating: 5
MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option: 
q

*/