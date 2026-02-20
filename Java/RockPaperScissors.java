import javax.swing.JOptionPane;

public class RockPaperScissors {
    public static void main(String[] args) {
        int rounds = 10;
        int draw = 0;
        int win = 0;
        int lose = 0;

        for(int i = 0; i < rounds; i++) {
            boolean goodChoice = false;
            Choices playerChoice = Choices.rock;
            while(goodChoice == false) {
                JOptionPane.showMessageDialog(null, "Round: " + (i + 1));
                String input = JOptionPane.showInputDialog(null, "Type rock, paper, or scissors!");
                String playerInput = input.toLowerCase();
                if (playerInput.charAt(0) == 'r' && playerInput.charAt(1) == 'o') {
                    playerChoice = Choices.rock;
                    goodChoice = true;
                } else if (playerInput.charAt(0) == 'p' && playerInput.charAt(1) == 'a') {
                    playerChoice = Choices.paper;
                    goodChoice = true;
                } else if (playerInput.charAt(0) == 's' && playerInput.charAt(1) == 'c') {
                    playerChoice = Choices.scissors;
                    goodChoice = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input, try again.");
                }
            }
            String combat = playerChoice.versus(Choices.randomChoice());
            if (combat.charAt(5) == 'a') {
                draw += 1;
            } else if (combat.charAt(5) == 'i') {
                win += 1;
            } else {
                lose += 1;
            } 

            JOptionPane.showMessageDialog(null, combat);
            JOptionPane.showMessageDialog(null, "Wins: " + win + " Loses: " + lose + " Draws: " + draw);
        }
        if (win > lose) {
            JOptionPane.showMessageDialog(null, "You won the match!");
        } else if (win < lose) {
            JOptionPane.showMessageDialog(null, "You lose the match!");
        } else {
            JOptionPane.showMessageDialog(null, "It's Draws all around.");
        }
    }
    enum Choices {
        rock, paper, scissors;

        private int determineValue() {
            if(this == rock) {
                return 1;
            } else if (this == paper) {
                return 2;
            } else {
                return 3;
            }
        }
        public Choices getChoice() {
            return this;
        }
        public static Choices randomChoice() {
            Choices[] choices = Choices.values();
            int index = (int)(Math.random() * choices.length);
            return choices[index];
        }

        public String versus(Choices choice) {
            String result = "";
            JOptionPane.showMessageDialog(null, "You played: " + this.getChoice());
            switch(this.determineValue()) {
                case 1:
                if (choice.determineValue() == 1) {
                    JOptionPane.showMessageDialog(null, "Your opponent played: " + choice.getChoice());
                    return result = "It's a Draw!";
                } else if (choice.determineValue() == 2) {
                    JOptionPane.showMessageDialog(null, "Your opponent played: " + choice.getChoice());
                    return result = "You Lose!";
                } else {
                    JOptionPane.showMessageDialog(null, "Your opponent played: " + choice.getChoice());
                    return result = "You Win!";
                }
                case 2:
                if (choice.determineValue() == 2) {
                    JOptionPane.showMessageDialog(null, "Your opponent played: " + choice.getChoice());
                    return result = "It's a Draw!";
                } else if (choice.determineValue() == 3) {
                    JOptionPane.showMessageDialog(null, "Your opponent played: " + choice.getChoice());
                    return result = "You Lose!";
                } else {
                    JOptionPane.showMessageDialog(null, "Your opponent played: " + choice.getChoice());
                    return result = "You Win!";
                }

                case 3: 
                if (choice.determineValue() == 3) {
                    JOptionPane.showMessageDialog(null, "Your opponent played: " + choice.getChoice());
                    return result = "It's a Draw!";
                } else if (choice.determineValue() == 1) {
                    JOptionPane.showMessageDialog(null, "Your opponent played: " + choice.getChoice());
                    return result = "You Lose!";
                } else {
                    JOptionPane.showMessageDialog(null, "Your opponent played: " + choice.getChoice());
                    return result = "You Win!";
                }
            }
            return result;
        }
    }
}
