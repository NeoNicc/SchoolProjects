import javax.swing.JOptionPane;
//create a mad lib. asks for 5 words and inserts them into, "Hey Diddle Diddle"
public class MadLib {
    public static void main(String[] args) {
        //Accept inputs for words to be added to the nursury rhyme
        String wordOne = JOptionPane.showInputDialog(null, "Enter an animal");
        String wordTwo = JOptionPane.showInputDialog(null, "Enter a noun");
        String wordThree = JOptionPane.showInputDialog(null, "Enter an adjective");
        String wordFour = JOptionPane.showInputDialog(null, "Enter a noun");
        String wordFive = JOptionPane.showInputDialog(null, "Enter a kitchen appliance");

        //The newly created nursery rhyme
        String nurseryRhyme = "Hey diddle diddle\nThe " + wordOne + " and the fiddle\nThe " + wordTwo + " jumped over the moon" + "\nThe " + wordThree + " " + wordFour + " laughed to see such sport\nAnd the " + wordFive + " ran away with the spoon.";
        
        //The deliver of the nursery rhyme via message box
        JOptionPane.showMessageDialog(null, nurseryRhyme);
    }
}
