import javax.swing.JOptionPane;

public class RentalDemo {
    public static void main(String[] args) {
        Rental rental1 = new Rental();
        Rental rental2 = new Rental(inputContractNum(), inputRentalTime());
        //initial welcome
        displayMotto();

        //check that the correct type of value was entered and calculate the total price
        viewFinalCharges(rental1);
        viewFinalCharges(rental2);
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
    public static String inputContractNum() {
        String contractNumInput = JOptionPane.showInputDialog(null, "What is the Contract Number?");
        return contractNumInput;
    }

    public static void displayMotto() {
        JOptionPane.showMessageDialog(null, "SSSSSSSSSSSSSSSSSSSSSSSSSSS\nS Sammy's makes it fun in the sun! S\nSSSSSSSSSSSSSSSSSSSSSSSSSSS");
    }
    public static void viewFinalCharges(Rental rental) {
        int baseCharge = rental.getRentedHours() * 40;
        int additionalFees = rental.getMinutesOverHour();
        int totalCost = baseCharge + additionalFees;

        //display pricing information
        JOptionPane.showMessageDialog(null, "Your contract number is " + rental.getContractNum() + ". \nYou rented your equipment for " + rental.getRentedHours() + " hours and " + rental.getMinutesOverHour() + " minutes. \nThe total cost today will be: $" + totalCost);
    }
}
