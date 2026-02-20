import javax.swing.JOptionPane;

public class Lottery {
    public static void main(String[] args) {
        final int[] lottoNums = getLottoNums();
        final int score = compare(lottoNums);
        if(score == 0) {
            System.out.println("Better luck next time!");
        } else if(score == 1_000_000) {
            System.out.println("YOU GOT ALL OF THEM");
        } else {
            System.out.println("You won: " + score + " points!");
        }
    }
    public static int[] getLottoNums() {
        int[] lottoNums = new int[3];

        for(int i = 0; i < lottoNums.length; i++) {
            lottoNums[i] = (int)(Math.random() * 10);
        }

        for(int num : lottoNums) {
            System.out.println(num);
        }
        return lottoNums;
    }
    public static int[] getGuesses() {
        JOptionPane.showMessageDialog(null, "Guess 3 numbers. The closer you get to matching all 3 the better!");
        String input1 = JOptionPane.showInputDialog(null, "What is your first guess?");
        String input2 = JOptionPane.showInputDialog(null, "What is your second guess?");
        String input3 = JOptionPane.showInputDialog(null, "What is your third guess?");

        int[] guesses = new int[3];
        guesses[0] = Integer.parseInt(input1);
        guesses[1] = Integer.parseInt(input2);
        guesses[2] = Integer.parseInt(input3);
        return guesses;
    }
    public static int compare(int[] lotto) {
        int[] myGuess = getGuesses();
        int exactMatches = 0;
        int slantMatches = 0;
        int finalPoints = 0;
        boolean alreadyFound = false;

        for(int i = 0; i < lotto.length; i++) {
            alreadyFound = false;
            for(int num : lotto) {
                if(lotto[i] == myGuess[i] && alreadyFound == false) {
                    exactMatches += 1;
                    alreadyFound = true;
                }
                if(myGuess[i] == num && alreadyFound == false) {
                    if(i == 1) {
                        if(myGuess[i-1] != lotto[i-1]) {
                            slantMatches += 1;
                            alreadyFound = true;
                        } 
                    } else if(i == 2) {
                        if(myGuess[i-2] != lotto[i-2] && myGuess[i-1] != lotto[i-1]) {
                            slantMatches += 1;
                            alreadyFound = true;
                        } 
                    } else {
                        slantMatches += 1;
                        alreadyFound = true;
                    }
                }
            }
        }
    
        if(exactMatches == 3) {
            finalPoints += 1000000;
        }
        switch(slantMatches + exactMatches) {
            case 0:
            break;

            case 1:
            finalPoints += 10;
            break;

            case 2:
            finalPoints += 100;
            break;

            case 3:
            finalPoints += 1000;
            break;
        }
        return finalPoints;
    }
}
