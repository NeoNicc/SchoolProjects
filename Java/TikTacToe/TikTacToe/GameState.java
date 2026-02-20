package TikTacToe.TikTacToe;
import javax.swing.JOptionPane;
import java.util.Arrays;

public class GameState {
    public String[][] gameBoard = {
        {"1", "2", "3"},
        {"4", "5", "6"},
        {"7", "8", "9"}
    };

    public boolean turn() {
        String oppChoice;
        boolean isGoodChoice = false;

        JOptionPane.showMessageDialog(null, "" + gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2] + "\n" + gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2] + "\n" + gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2]);

        while(isGoodChoice == false) {
            String playerChoice = JOptionPane.showInputDialog(null, "Choose which space to mark X");
            isGoodChoice = placeMark(playerChoice, "player");
            
            if(checkForWin(gameBoard) == true) {
                JOptionPane.showMessageDialog(null, "You Win!");
                return true;
            }
        }
        isGoodChoice = false;
        while (isGoodChoice == false) {
            int randomChoice = (int)Math.floor((Math.random() * 9) + 1);
            oppChoice = randomChoice + "";
            isGoodChoice = placeMark(oppChoice, "opp");
            
            if(checkForLoss(gameBoard) == true) {
                JOptionPane.showMessageDialog(null, "You Lose!");
                return true;
            }
        }
        int endGameCount = 0;
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(gameBoard[i][j].equals("X") || gameBoard[i][j].equals("O")) {
                    endGameCount++;
                }
            }
        }
        if(endGameCount == 9) {
            JOptionPane.showMessageDialog(null, "It's a Draw!");
            return true;
        }
        return false;
    }

    public boolean placeMark(String here, String player) {
        if(player.equals("player")) {
            switch (here) {
                case "1":
                    if(gameBoard[0][0].equals("1")) {
                        gameBoard[0][0] = "X";
                        
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "This position is already marked!");
                        return false;
                    }
                case "2":
                    if(gameBoard[0][1].equals("2")) {
                        gameBoard[0][1] = "X";
                        
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "This position is already marked!");
                        return false;
                    }
                case "3":
                    if(gameBoard[0][2].equals("3")) {
                        gameBoard[0][2] = "X";
                        
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "This position is already marked!");
                         return false;
                    }
                case "4":
                    if(gameBoard[1][0].equals("4")) {
                        gameBoard[1][0] = "X";
                        
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "This position is already marked!");
                        return false;
                    }
                case "5":
                    if(gameBoard[1][1].equals("5")) {
                        gameBoard[1][1] = "X";
                        
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "This position is already marked!");
                        return false;
                    }
                case "6":
                    if(gameBoard[1][2].equals("6")) {
                        gameBoard[1][2] = "X";
                        
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "This position is already marked!");
                        return false;
                    }
                case "7":
                    if(gameBoard[2][0].equals("7")) {
                        gameBoard[2][0] = "X";
                        
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "This position is already marked!");
                        return false;
                    }
                case "8":
                    if(gameBoard[2][1].equals("8")) {
                        gameBoard[2][1] = "X";
                        
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "This position is already marked!");
                        return false;
                    }
                case "9":
                    if(gameBoard[2][2].equals("9")) {
                        gameBoard[2][2] = "X";
                        
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "This position is already marked!");
                        return false;
                    }
                default:
                    return false;
                }
            } else {
                switch (here) {
                    case "1":
                        if(gameBoard[0][0].equals("1")) {
                            gameBoard[0][0] = "O";
                            
                            return true;
                        } else {
                            return false;
                        }
                    case "2":
                        if(gameBoard[0][1].equals("2")) {
                            gameBoard[0][1] = "O";
                            
                            return true;
                        } else {
                            return false;
                        }
                    case "3":
                        if(gameBoard[0][2].equals("3")) {
                            gameBoard[0][2] = "O";
                            
                            return true;
                        } else {
                            return false;
                        }
                    case "4":
                        if(gameBoard[1][0].equals("4")) {
                            gameBoard[1][0] = "O";
                            
                            return true;
                        } else {
                            return false;
                        }
                    case "5":
                        if(gameBoard[1][1].equals("5")) {
                            gameBoard[1][1] = "O";
                            
                            return true;
                        } else {
                            return false;
                        }
                    case "6":
                        if(gameBoard[1][2].equals("6")) {
                            gameBoard[1][2] = "O";
                            
                            return true;
                        } else {
                            return false;
                        }
                    case "7":
                        if(gameBoard[2][0].equals("7")) {
                            gameBoard[2][0] = "O";
                            
                            return true;
                        } else {
                            return false;
                        }
                    case "8":
                        if(gameBoard[2][1].equals("8")) {
                            gameBoard[2][1] = "O";
                            
                            return true;
                        } else {
                            return false;
                        }
                    case "9":
                        if(gameBoard[2][2].equals("9")) {
                            gameBoard[2][2] = "O";
                            
                            return true;
                        } else {
                            return false;
                        }
                    default:
                        return false;
                }
            }
        
    }

    private boolean checkForWin(String[][] currentBoard) {
        String[] testWin = {"X", "X", "X"};
        if (Arrays.equals(currentBoard[0], testWin) == true || Arrays.equals(currentBoard[1], testWin) == true || Arrays.equals(currentBoard[2], testWin) == true) {
            return true;
        } else if (currentBoard[0][0].equals("X") == true && currentBoard[1][0].equals("X") == true && currentBoard[2][0].equals("X") == true) {
            return true;
        } else if (currentBoard[0][1].equals("X") == true && currentBoard[1][1].equals("X") == true && currentBoard[2][1].equals("X") == true) {
            return true;
        } else if (currentBoard[0][2].equals("X") == true && currentBoard[1][2].equals("X") == true && currentBoard[2][2].equals("X") == true) {
            return true;
        } else if (currentBoard[0][0].equals("X") == true && currentBoard[1][1].equals("X") == true && currentBoard[2][2].equals("X") == true) {
            return true;
        } else if (currentBoard[0][2].equals("X") == true && currentBoard[1][1].equals("X") == true && currentBoard[2][0].equals("X") == true) {
            return true;
        } else {
            return false;
        }
    }
    private boolean checkForLoss(String[][] currentBoard) {
        String[] testLoss = {"O", "O", "O"};
        if (Arrays.equals(currentBoard[0], testLoss) == true || Arrays.equals(currentBoard[1], testLoss) == true || Arrays.equals(currentBoard[2], testLoss) == true) {
            return true;
        } else if (currentBoard[0][0].equals("O") == true && currentBoard[1][0].equals("O") == true && currentBoard[2][0].equals("O") == true) {
            return true;
        } else if (currentBoard[0][1].equals("O") == true && currentBoard[1][1].equals("O") == true && currentBoard[2][1].equals("O") == true) {
            return true;
        } else if (currentBoard[0][2].equals("O") == true && currentBoard[1][2].equals("O") == true && currentBoard[2][2].equals("O") == true) {
            return true;
        } else if (currentBoard[0][0].equals("O") == true && currentBoard[1][1].equals("O") == true && currentBoard[2][2].equals("O") == true) {
            return true;
        } else if (currentBoard[0][2].equals("O") == true && currentBoard[1][1].equals("O") == true && currentBoard[2][0].equals("O") == true) {
            return true;
        } else {
            return false;
        }
    }
}
