import javax.swing.JOptionPane;

public class SammysRentalPrice {
    public static void main(String[] args) {
        //initial welcome
        displayMotto();

        //get input for length of time equipment was rented
        int rentalLengthInput = inputRentalTime();

        //check that the correct type of value was entered and calculate the total price
        viewFinalCharges(rentalLengthInput);
    }
    public static int inputRentalTime() {
        String rentalLengthInput = JOptionPane.showInputDialog(null, "How many minutes did you rent your equipment?");
        try {
            return Integer.parseInt(rentalLengthInput);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "That's not a number of minutes.");
            return 0;
        }
    }
    public static void displayMotto() {
        JOptionPane.showMessageDialog(null, "SSSSSSSSSSSSSSSSSSSSSSSSSSS\nS Sammy's makes it fun in the sun! S\nSSSSSSSSSSSSSSSSSSSSSSSSSSS");
    }
    public static void viewFinalCharges(int rentalLengthInput) {
        try {
            int baseCharge = (rentalLengthInput/60) * 40;
            int additionalFees = (rentalLengthInput % 60);
            int totalCost = baseCharge + additionalFees;

            //display pricing information
            JOptionPane.showMessageDialog(null, "You rented your equipment for " + (rentalLengthInput/60) + " hours and " + (rentalLengthInput%60) + " minutes. The total cost today will be: $" + totalCost);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "That's not a number.");
        }
    }
}
