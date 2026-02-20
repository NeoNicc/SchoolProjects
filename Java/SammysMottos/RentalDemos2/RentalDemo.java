import javax.swing.JOptionPane;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class RentalDemo {
    public static void main(String[] args) {
        JSammys frame = new JSammys("Sammy's Rentals");
        //The following code is for use with the base class Rental
        /*Rental rental1 = new Rental();
        Rental rental2 = new Rental(inputContractNum(), inputRentalTime(), inputEquipmentType());
        Rental rental3 = new Rental(inputContractNum(), inputRentalTime(), inputEquipmentType());
        Rental rental4 = new Rental(inputContractNum(), inputRentalTime(), inputEquipmentType());

        //show welcome message
        displayMotto();
        
        //view charges for the 2 rentals above
        viewFinalCharges(rental1);
        viewFinalCharges(rental2);
        viewFinalCharges(rental3);
        viewFinalCharges(rental4);

        Path file = Paths.get("C:\\Users\\linbr\\OneDrive\\Documents\\.Nikki School\\Java\\SammysMottos\\RentalDemos2\\EventInfo.txt");
        //string to be saved to file below
        String savedString = "Rental 1\nContract Number: " + rental1.getContractNum() + "\nRental Time: " + rental1.getRentedHours() + " hours and " + rental1.getMinutesOverHour() + " minutes\nEquipment: " + rental1.getEquipment().getEquipmentName() + "\nPrice: $" + rental1.getPrice() + "\n\nRental 2\nContract Number: " + rental2.getContractNum() + "\nRental Time: " + rental2.getRentedHours() + " hours and " + rental2.getMinutesOverHour() + " minutes\nEquipment: " + rental2.getEquipment().getEquipmentName() + "\nPrice: $" + rental2.getPrice() + "\n\nRental 3\nContract Number: " + rental3.getContractNum() + "\nRental Time: " + rental3.getRentedHours() + " hours and " + rental3.getMinutesOverHour() + " minutes\nEquipment: " + rental3.getEquipment().getEquipmentName() + "\nPrice: $" + rental3.getPrice() + "\n\nRental 4\nContract Number: " + rental4.getContractNum() + "\nRental Time: " + rental4.getRentedHours() + " hours and " + rental4.getMinutesOverHour() + " minutes\nEquipment: " + rental4.getEquipment().getEquipmentName() + "\nPrice: $" + rental4.getPrice();
        //end of string to be saved

        byte[] data = savedString.getBytes();
        OutputStream output = null;
        try {
            output = new BufferedOutputStream(Files.newOutputStream(file, TRUNCATE_EXISTING));
            output.write(data);
            output.flush();
            output.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            */
    }
    //request number of minutes equipment was rented for
    public static int inputRentalTime() {
        while(true) {
            try {
                String rentalLengthInput = JOptionPane.showInputDialog(null, "How many minutes did you rent your equipment?");
                return Integer.parseInt(rentalLengthInput);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "That's not a number of minutes.");
            }
        }
    }
    //request a contract number
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
        int moreAdditionalFees = rental.getEquipment().getEquipmentFee();
        int totalCost = baseCharge + additionalFees + moreAdditionalFees;

        //display pricing information
        JOptionPane.showMessageDialog(null, "Your contract number is " + rental.getContractNum() + ". \nYou rented your equipment for " + rental.getRentedHours() + " hours and " + rental.getMinutesOverHour() + " minutes. \nYou rented a/n " + rental.getEquipment().getEquipmentName() + ". For $" + rental.getEquipment().getEquipmentFee() + "\n" + rental.getEquipment().lessonPolicy() + "\nThe total cost today will be: $" + totalCost);
    }
    public static String inputEquipmentType() {
        String typeInput = JOptionPane.showInputDialog(null, "Enter the type of equipment you will use.\n" + Equipment.displayEquipmentNames());
        return typeInput;
    }
}
