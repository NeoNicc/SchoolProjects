import java.util.Scanner;
import java.util.Random;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      final int ROCK = 0;
      final int PAPER = 1;
      final int SCISSORS = 2;
      Random rand = new Random();
      int seed = scnr.nextInt();
      rand.setSeed(seed);

      /* Insert your code here */
      //scanning in player names
      String name1 = scnr.next();
      String name2 = scnr.next();
      //scanning in round count
      int rounds = 0;
      while(true) {
    	  rounds = scnr.nextInt();
    	  //validate input is a natural number
    	  if (rounds < 1) {
    		  System.out.println("Rounds must be > 0");
    	  } else {
    		  break;
    	  }
      }
      
      //output versus statement with names and rounds
      if (rounds == 1) {
    	  System.out.println(name1 + " vs " + name2 + " for " + rounds + " rounds"); //originally had fixed verbiage for single and plural
      } else {
    	  System.out.println(name1 + " vs " + name2 + " for " + rounds + " rounds");
      }
      
      //initialize player choices
      int player1Choice;
      int player2Choice;
      
      //initialize scores
      int player1Score = 0;
      int player2Score = 0;
      
      //determine winner or tie status 
      //for each round
      for (int i = 0; i < rounds; i++) {
    	  //System.out.println(player1Score + ", " + player2Score);
    	  //determine player choices
    	  player1Choice = rand.nextInt(3);
          player2Choice = rand.nextInt(3);
          
          //determine points gained or tie
    	  if (player1Choice == player2Choice) {
    		  i--;
    		  System.out.println("Tie");
    	  } else if (player1Choice > 1 && player2Choice > 0) {
    		  player1Score += 1;
    		  System.out.println(name1 + " wins with scissors");
    	  } else if (player2Choice > 1 && player1Choice > 0) {
    		  player2Score += 1;
    		  System.out.println(name2 + " wins with scissors");
    	  } else if (player1Choice > 1) {
    		  player2Score += 1;
    		  System.out.println(name2 + " wins with rock");
    	  } else if (player2Choice > 1) {
    		  player1Score += 1;
    		  System.out.println(name1 + " wins with rock");
    	  } else if (player1Choice == 1){
    		  player1Score += 1;
    		  System.out.println(name1 + " wins with paper");
    	  } else {
    		  player2Score += 1;
    		  System.out.println(name2 + " wins with paper");
    	  }
      }
      
      //print final result
      if (player1Score == player2Score) {
    	  System.out.println("Tie");
      } else {
    	  System.out.println(name1 + " wins " + player1Score + " and " + name2 + " wins " + player2Score);
      }
      scnr.close();
   }
}
//Output
//first
/*
	3 nikki lin -1
	Rounds must be > 0
	-4
	Rounds must be > 0
	2
	nikki vs lin for 2 rounds
 */
//second
/*
	4 nikki lin 3
	nikki vs lin for 3 rounds
	Tie

 */
//third
/*
	3 nikki lin 3
	nikki vs lin for 3 rounds
	Tie
	paper covers rock
	Tie
*/
//fourth
/*
	4 nikki lin 3
	nikki vs lin for 3 rounds
	0, 0
	nikki wins with scissors
	1, 0
	lin wins with paper
	1, 1
	Tie
	1, 1
	Tie
	1, 1
	lin wins with paper
	nikki wins 1 and lin wins 2
*/