package DoesItHaveLegs;
import javax.swing.JOptionPane;

public class DoesItHaveLegs {
    public static void main(String[] args) {
        //establish the game
        AnimalsTree animals = new AnimalsTree();

        //keeps playing the game as long as the user keeps typing yes to the play again prompt
        while(true) {
            animals.play();
            String playAgain = JOptionPane.showInputDialog(null, "Do you want to play again? (yes/no)").toLowerCase();

            if (playAgain.equals("yes") != true) {
                break;
            }
        }
    }
}
