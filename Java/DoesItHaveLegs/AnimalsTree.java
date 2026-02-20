package DoesItHaveLegs;
import javax.swing.JOptionPane;

public class AnimalsTree {
    private Animal root;

    public AnimalsTree() {
        root = new Animal("Dog", false);
    }

    //initiating gameplay
    public void play() {
        Animal current = root;
        Animal parent = null;

        String noReasonQuestion = JOptionPane.showInputDialog(null, "Does it have legs? (yes/no)");

        while (current.isQuestion) {
            String answer = JOptionPane.showInputDialog(null, current.data + " (yes/no)").toLowerCase();
            parent = current;

            if(answer.equals("yes")) {
                current = current.yes;
            } else {
                current = current.no;
            }
        }
        //guessing the animal
        String answer = JOptionPane.showInputDialog(null, "Is it a " + current.data + "? (yes/no)").toLowerCase();

        if (answer.equals("yes")) {
            JOptionPane.showMessageDialog(null, "Yay! I win!");
        } else {
            //learning
            String newAnimal = JOptionPane.showInputDialog(null, "I give up, what was your animal?");
            String newQuestion = JOptionPane.showInputDialog(null, "Type a yes or no question that is yes for " + current.data + " but no for " + newAnimal + ".");

            Animal animal = new Animal(newAnimal, false);
            Animal oldAnimal = new Animal(current.data, false);

            //replace current with a question
            current.data = newQuestion;
            current.isQuestion = true;
            current.yes = oldAnimal;
            current.no = animal;
        }
    }
}
