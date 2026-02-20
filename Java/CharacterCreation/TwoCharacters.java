package CharacterCreation;
import javax.swing.JOptionPane;

public class TwoCharacters {
    public static void main(String[] args) {
        MyCharacter firstCharacter = new MyCharacter();
        firstCharacter.setHealth(10);
        firstCharacter.setStamina(6);
        firstCharacter.setMagic(2);

        MyCharacter secondCharacter = new MyCharacter();
        secondCharacter.setHealth(7);
        secondCharacter.setStamina(3);
        secondCharacter.setMagic(10);

        JOptionPane.showMessageDialog(null, "The first Character has " + firstCharacter.getHealth() + " Health, " + firstCharacter.getStamina() + " Stamina, and " + firstCharacter.getMagic() + " Magic.");

        JOptionPane.showMessageDialog(null, "The second Character has " + secondCharacter.getHealth() + " Health, " + secondCharacter.getStamina() + " Stamina, and " + secondCharacter.getMagic() + " Magic.");
    }
}
