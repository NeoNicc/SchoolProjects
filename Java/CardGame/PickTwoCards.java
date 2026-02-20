package CardGame;
import javax.swing.JOptionPane;

public class PickTwoCards {
    public static void main(String[] args) {
        final int CARDS_IN_SUIT = 13;
        char[] suits = {'s', 'h', 'd', 'c'};

        //first card
        Card firstCard = new Card();
        firstCard.setCardNum((int)(Math.random() * CARDS_IN_SUIT) + 1);
        firstCard.setSuit(suits[(int)(Math.random() * suits.length)]);

        //second card
        Card secondCard = new Card();
        secondCard.setCardNum((int)(Math.random() * CARDS_IN_SUIT) + 1);
        secondCard.setSuit(suits[(int)(Math.random() * suits.length)]);

        //reveals the cards
        JOptionPane.showMessageDialog(null, "The First Card is " + firstCard.getCardNum() + " of " + getSuitName(firstCard.getSuit()));

        JOptionPane.showMessageDialog(null, "The second Card is " + secondCard.getCardNum() + " of " + getSuitName(secondCard.getSuit()));
    }

    public static String getSuitName(char suit) {
        switch (suit) {
            case 's': return "Spades";
            case 'h': return "Hearts";
            case 'd': return "Diamonds";
            case 'c': return "Clubs";
            default: return "";
        }
    }
}
