//An event scheduled at Carly's Catering

public class Event {
    public final static int pricePerGuest = 35;
    public final static int largePartyCutoff = 50;
    private String eventNum;
    private int guestCount;
    private int price;

    public Event(String eventNum, int guestCount) {
        setEventNum(eventNum);
        setGuestCount(guestCount);
    }
    public Event() {
        this("A000", 0);
    }

    public void setEventNum(String eventNum) {
        this.eventNum = eventNum;
    }
    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public String getEventNum() {
        return eventNum;
    }
    public int getGuestCount() {
        return guestCount;
    }
    public int getPrice() {
        price = pricePerGuest * guestCount;
        return price;
    }
    public int getIsLargeParty() {
        if(guestCount > largePartyCutoff) {
            return 1;
        } else {
            return 0;
        }
    }
}
