import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Comparator;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class EventDemo {
    public static void main(String[] args) {
        //These events use the Base Class Event
        //uncomment the lines with commands to use the base class version

        //An event made by the user
        //Event event1 = new Event(requestEventNum(), requestGuestNum());
        //An empty event resulting in A001 and 1's
        //Event event2 = new Event();
        //More events to fill the list of events
        //Event event3 = new Event("Lmn003", 80);
        //Event event4 = new Event("Lmn005", 44);
        //Event event5 = new Event("Lmn008", 34);
        //Event event6 = new Event("Lmn009", 90);
        //Event event7 = new Event("Lmn012", 299);
        //Event event8 = new Event("Lmn018", 1003);
        //list of all events currently booked
        //Event[] listOfEvents = {event1, event2, event3, event4, event5, event6, event7, event8};

        //showMotto();
        FoodChoices foodChoices = new FoodChoices("Food Choices");

        //These events use the DinnerEvent subclass
        //all events are user determined
        //DinnerEvent dinnerEvent1 = new DinnerEvent(requestEventNum(), requestGuestNum(), requestEntree(foodChoices), requestSideOne(), requestSideTwo(), requestDessert());
        //dinnerEvent1.setEmployees(dinnerEvent1.getGuestCount());

        //DinnerEvent dinnerEvent2 = new DinnerEvent(requestEventNum(), requestGuestNum(), requestEntree(foodChoices), requestSideOne(), requestSideTwo(), requestDessert());
        //dinnerEvent2.setEmployees(dinnerEvent2.getGuestCount());

        //DinnerEvent dinnerEvent3 = new DinnerEvent(requestEventNum(), requestGuestNum(), requestEntree(foodChoices), requestSideOne(), requestSideTwo(), requestDessert());
        //dinnerEvent3.setEmployees(dinnerEvent3.getGuestCount());

        //Path file = Paths.get("C:\\Users\\linbr\\OneDrive\\Documents\\.Nikki School\\Java\\CarlysMottos\\CarlysEvents2\\EventInfo.txt");
        //String data = "Event 1 \nEvent Number: " + dinnerEvent1.getEventNum() + "\nNumber of Guests: " + dinnerEvent1.getGuestCount() + "\nPrice: " + dinnerEvent1.getPrice();// + "\n\nEvent 2 \nEvent Number: " + dinnerEvent2.getEventNum() + "\nNumber of Guests: " + dinnerEvent2.getGuestCount() + "\nPrice: " + dinnerEvent2.getPrice() + "\n\nEvent 3 \nEvent Number: " + dinnerEvent3.getEventNum() + "\nNumber of Guests: " + dinnerEvent3.getGuestCount() + "\nPrice: " + dinnerEvent3.getPrice();
        //byte[] byteData = data.getBytes();
        // output = null;
        /*try {
            output = new BufferedOutputStream(Files.newOutputStream(file, TRUNCATE_EXISTING));
            output.write(byteData);
            output.flush();
            output.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
*/
        /*DinnerEvent dinnerEvent2 = new DinnerEvent(requestEventNum(), requestGuestNum(), requestEntree(), requestSideOne(), requestSideTwo(), requestDessert());
        DinnerEvent dinnerEvent3 = new DinnerEvent(requestEventNum(), requestGuestNum(), requestEntree(), requestSideOne(), requestSideTwo(), requestDessert());
        DinnerEvent dinnerEvent4 = new DinnerEvent(requestEventNum(), requestGuestNum(), requestEntree(), requestSideOne(), requestSideTwo(), requestDessert());*/

        //list of dinner events currently booked
        //DinnerEvent[] listOfDinnerEvents = {dinnerEvent1, dinnerEvent2, dinnerEvent3, dinnerEvent4};

        //To run Base Class Demo uncomment below
        //showMotto();
        //calculateTotal(event1);
        //calculateTotal(event2);
        //sortingLoop(listOfEvents);

        //To run with DinnerEvent subclass
        //showMotto();
        //sortingLoop(listOfDinnerEvents);
        //calculateTotal(dinnerEvent1);
        
    }
    //display business title
    public static void showMotto() {
        JOptionPane.showMessageDialog(null, "***********************************************************\n* Carly's makes the food that makes it a party! *\n***********************************************************");
    }

    //asks user for number of guests attending the event
    public static int requestGuestNum() {
        while(true) {
            try {
                String inputGuestCount = JOptionPane.showInputDialog(null, "How many guests will be attending?");
                int guestCount = Integer.parseInt(inputGuestCount);
                return guestCount;
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "That's not a number.");
            }
        }
    }
    //asks user for the event number
    public static String requestEventNum() {
        String inputEventNum = JOptionPane.showInputDialog(null, "What will be the Event Number?");

        return inputEventNum;
    }
    //asks user for entree option
    public static int requestEntree(FoodChoices foods) {
        int entreeChoice = JOptionPane.showOptionDialog(null, "Entree Options:", "Entrees", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, DinnerEvent.entrees, DinnerEvent.entrees[0]);

        return entreeChoice;
    }
    //asks user for side option
    public static int requestSideOne() {
        int sideOneChoice = JOptionPane.showOptionDialog(null, "Side Options 1/2:", "Sides", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, DinnerEvent.sides, DinnerEvent.sides[0]);

        return sideOneChoice;
    }
    //asks user for side option number two
    public static int requestSideTwo() {
        int sideTwoChoice = JOptionPane.showOptionDialog(null, "Side Options 2/2:", "Sides", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, DinnerEvent.sides, DinnerEvent.sides[0]);

        return sideTwoChoice;
    }
    //asks user for dessert option
    public static int requestDessert() {
        int dessertChoice = JOptionPane.showOptionDialog(null, "Dessert Options:", "Dessertz", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, DinnerEvent.desserts, DinnerEvent.desserts[0]);

        return dessertChoice;
    }

    //displays a message of a single event's fields
    public static void calculateTotal(Event event){
        boolean isLargeParty = false;
        JOptionPane.showMessageDialog(null, "Event Number: " + event.getEventNum() + "\nGuest Count: " + event.getGuestCount() + "\nPrice per Guest: " + Event.pricePerGuest + "\nTotal Price: " + event.getPrice());
        //determine if the party is large based on the cutoff threshold
        if(event.getGuestCount() >= Event.largePartyCutoff) {
            isLargeParty = true;
            JOptionPane.showMessageDialog(null, "Large Party: " + isLargeParty);
        }
    }
    public static void calculateTotal(DinnerEvent event){
        boolean isLargeParty = false;
        JOptionPane.showMessageDialog(null, "Event Number: " + event.getEventNum() + "\nGuest Count: " + event.getGuestCount() + "\nPrice per Guest: " + Event.pricePerGuest + "\nTotal Price: " + event.getPrice() + "\n" + event.getMenu() + "\n" + event.displayEmployees());
        //determine if the party is large based on the cutoff threshold
        if(event.getGuestCount() >= Event.largePartyCutoff) {
            isLargeParty = true;
            JOptionPane.showMessageDialog(null, "Large Party: " + isLargeParty);
        }
    }

    //asks the user how they'd like to sort the list of events
    //there are three options and an exit
    public static void sortingLoop(Event[] eventList) {
        boolean isRunning = true;
        while(isRunning != false) {
            String whichSortType = JOptionPane.showInputDialog(null, "Would you like to sort by Event Number, number of guests, by type, or to quit type 4. (1/2/3/4)");
            switch(whichSortType) {
                //sort by ascending event number
                case "1":
                    Arrays.sort(eventList, Comparator.comparing(e -> e.getEventNum()));
                    for (int i = 0; i < eventList.length; i++) {
                        JOptionPane.showMessageDialog(null, "Event Number: " + eventList[i].getEventNum());
                    }
                    break;
                //sort by ascending attendance number
                case "2":
                    Arrays.sort(eventList, Comparator.comparingInt(e -> e.getGuestCount()));
                    for (int i = 0; i < eventList.length; i++) {
                        JOptionPane.showMessageDialog(null, "Guest Count: " + eventList[i].getGuestCount());
                    }
                    break;
                //sort by whether it is a large party or not
                //is all nos then all yes's (ascending)
                case "3":
                    Arrays.sort(eventList, Comparator.comparingInt(e -> e.getIsLargeParty()));
                    for (int i = 0; i < eventList.length; i++) {
                        if (eventList[i].getIsLargeParty() == 1) {
                            JOptionPane.showMessageDialog(null, "Large Party: Yes");
                        } else {
                            JOptionPane.showMessageDialog(null, "Large Party: No");
                        }
                    }
                    break;
                case "4":
                    isRunning = false;
                    break;
                default: 
                    break;
            }
        }
    }
}
