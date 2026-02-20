import javax.swing.JOptionPane;

public class RandomGuessMatch {
    public static void main(String[] args) {
        while(true) {
            int numberChoice = 0;

            String input = JOptionPane.showInputDialog(null, "Enter a number between 1 and 5.");

            if (input == null) {
                return;
            }

            try {
                numberChoice = Integer.parseInt(input);

                if (numberChoice >= 1 && numberChoice <= 5) {
                    //generate the random number
                    int randomNumber = (1+(int)(Math.random()*5));

                    //judge you based on your guess
                    if (numberChoice == randomNumber){
                        JOptionPane.showMessageDialog(null, "You were spot on!");
                    } else if (numberChoice < randomNumber) {
                        JOptionPane.showMessageDialog(null, "You guessed too low.");
                    } else {
                        JOptionPane.showMessageDialog(null, "You guessed too high");
                    }

                    //exit the loop
                    JOptionPane.showMessageDialog(null, "The number is "+randomNumber);
                    return; 
                } else {
                    //chose a number out of range
                    JOptionPane.showMessageDialog(null, "A number between 1 and 10 please.");
                }
            } catch(NumberFormatException e) {
                //entered the wrong format like a string
                JOptionPane.showMessageDialog(null, "That's not a number. Try again.");
            }
            
        }
    }
}
