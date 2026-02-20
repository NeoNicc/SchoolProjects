package CardGame;

public class Card {
    private char suit;
    private int cardNum;

    public void setSuit(char suit) {
        this.suit = suit;
    }
    public char getSuit() {
        return suit;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
    public int getCardNum() {
        return cardNum;
    }
}
