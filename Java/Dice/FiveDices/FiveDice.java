public class FiveDice {
    public static void main(String[] args) {
        Die[] playerRoll = new Die[5];
        Die[] oppRoll = new Die[5];

        Die playerDie1 = new Die();
        playerRoll[0] = playerDie1;
        Die playerDie2 = new Die();
        playerRoll[1] = playerDie2;
        Die playerDie3 = new Die();
        playerRoll[2] = playerDie3;
        Die playerDie4 = new Die();
        playerRoll[3] = playerDie4;
        Die playerDie5 = new Die();
        playerRoll[4] = playerDie5;

        Die opponentDie1 = new Die();
        oppRoll[0] = opponentDie1; 
        Die opponentDie2 = new Die();
        oppRoll[1] = opponentDie2;
        Die opponentDie3 = new Die();
        oppRoll[2] = opponentDie3;
        Die opponentDie4 = new Die();
        oppRoll[3] = opponentDie4;
        Die opponentDie5 = new Die();
        oppRoll[4] = opponentDie5;
        //message about what each player rolled
        final String space = " ";

        System.out.println("You rolled " + playerDie1.getResult() + space + playerDie2.getResult() + space + playerDie3.getResult() + space + playerDie4.getResult() + space + playerDie5.getResult());
        System.out.println("Your opponent rolled " + opponentDie1.getResult() + space + opponentDie2.getResult() + space + opponentDie3.getResult() + space + opponentDie4.getResult() + space + opponentDie5.getResult());

        int playerTurn = Integer.parseInt(match(playerRoll));
        int oppTurn = Integer.parseInt(match(oppRoll));

        if (playerTurn > oppTurn) {
            System.out.println("You had " + (playerTurn + 1) + " pair.\nYour opponent had " + oppTurn);
            System.out.println("You Win!");
        } else if (playerTurn < oppTurn) {
            System.out.println("They had " + (oppTurn + 1) + " pair.\nYou had " + playerTurn);
            System.out.println("You Lose!");
        } else {
            System.out.println("You both had " + playerTurn);
            System.out.println("It's a draw!");
        }
    }
    public static String match(Die[] player) {
        String playerMatches = "";

        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        int fourCount = 0;
        int fiveCount = 0;
        int sixCount = 0;
        int[] playerCounts = {oneCount, twoCount, threeCount, fourCount, fiveCount, sixCount};

        for(int i = 0; i < player.length; i++) {
            for(int num = 0; num < player.length; num++) {
                if (num != i) {
                    
                    if(player[i].getResult() == player[num].getResult()) {
                        playerMatches += player[num].getResult();
                        switch(player[num].getResult()) {
                            case 1:
                                playerCounts[oneCount] += 1;
                                break;
                            case 2:
                                playerCounts[twoCount] += 1;
                                break;
                            case 3:
                                playerCounts[threeCount] += 1;
                                break;
                            case 4:
                                playerCounts[fourCount] += 1;
                                break;
                            case 5:
                                playerCounts[fiveCount] += 1;
                                break;
                            case 6:
                                playerCounts[sixCount] += 1;
                                break;
                        }
                        player[i].setResult(0);
                    }
                }
            }
        }
        if (playerMatches.length() > 0) {
            int max = playerCounts[0];
            for (int i = 1; i < playerCounts.length; i++) {
                if (playerCounts[i] > max) {
                    max = playerCounts[i];
                }
            }
            return max + "";
        } else {
            return "0";
        }
    }
}
