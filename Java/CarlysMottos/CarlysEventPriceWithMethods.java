import javax.swing.JOptionPane;

public class CarlysEventPriceWithMethods {
    public static void main(String[] args) {
        showMotto();
        calculateTotal(requestGuestNum(), requestEventNum());
    }

    public static String requestGuestNum() {
        String inputGuestCount = JOptionPane.showInputDialog(null, "How many guests will be attending?");
        
        return inputGuestCount;
    }
    public static String requestEventNum() {
        String inputEventNum = JOptionPane.showInputDialog(null, "What will be the Event Number?");

        return inputEventNum;
    }

    public static void showMotto(){
        JOptionPane.showMessageDialog(null, "***********************************************************\n* Carly's makes the food that makes it a party! *\n***********************************************************");
    }
    public static void calculateTotal(String guests, String inputEventNum){
        Event event1 = new Event();
        boolean isLargeParty = false;
        try {
            int guestCount = Integer.parseInt(guests);
            event1.setEventNum(inputEventNum);
            event1.setGuestCount(guestCount);

            JOptionPane.showMessageDialog(null, "Event Number: " + event1.getEventNum() + "\nGuest Count: " + guestCount + "\nPrice per Guest: " + Event.pricePerGuest + "\nTotal Price: " + event1.getPrice());

            if(guestCount >= Event.largePartyCutoff) {
                isLargeParty = true;
                JOptionPane.showMessageDialog(null, "Large Party: " + isLargeParty);
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "That's not a number.");
        }
    }
}
