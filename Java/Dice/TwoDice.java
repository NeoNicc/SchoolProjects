public class TwoDice {
    public static void main(String[] args) {
        Die die = new Die();
        Die die2 = new Die();

        System.out.println("Die One: " + die.getResult());
        System.out.println("Die Two: " + die2.getResult());
    }
}
