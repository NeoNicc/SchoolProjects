import javax.swing.JOptionPane;

public class EventDemo {
    public static void main(String[] args) {
        Event event1 = new Event(requestEventNum(), requestGuestNum());
        Event event2 = new Event();
        
        showMotto();
        calculateTotal(event1);
        calculateTotal(event2);
    }

    public static void showMotto() {
        JOptionPane.showMessageDialog(null, "***********************************************************\n* Carly's makes the food that makes it a party! *\n***********************************************************");
    }
    public static int requestGuestNum() {
        String inputGuestCount = JOptionPane.showInputDialog(null, "How many guests will be attending?");
        try {
            int guestCount = Integer.parseInt(inputGuestCount);
            return guestCount;
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "That's not a number.");
            return 0;
        }
    }
    public static String requestEventNum() {
        String inputEventNum = JOptionPane.showInputDialog(null, "What will be the Event Number?");

        return inputEventNum;
    }

    public static void calculateTotal(Event event){
        boolean isLargeParty = false;
        JOptionPane.showMessageDialog(null, "Event Number: " + event.getEventNum() + "\nGuest Count: " + event.getGuestCount() + "\nPrice per Guest: " + Event.pricePerGuest + "\nTotal Price: " + event.getPrice());

        if(event.getGuestCount() >= Event.largePartyCutoff) {
            isLargeParty = true;
            JOptionPane.showMessageDialog(null, "Large Party: " + isLargeParty);
        }
    }
}
