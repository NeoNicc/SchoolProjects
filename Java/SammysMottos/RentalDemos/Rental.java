public class Rental {
    public final static int minutesInHour = 60;
    public final static int ratePerHour = 40;

    private String contractNum;
    private int rentedHours;
    private int minutesOverHour;
    private int price;

    public Rental(String contractNum, int minutes) {
        setContractNum(contractNum);
        setHoursAndMinutes(minutes);
    }
    public Rental() {
        this("A000", 0);
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }
    public void setHoursAndMinutes(int minutes) {
        this.rentedHours = minutes / minutesInHour;
        this.minutesOverHour = minutes % minutesInHour;
        this.price = (rentedHours * ratePerHour) + minutesOverHour;
    }

    public String getContractNum() {
        return contractNum;
    }
    public int getRentedHours() {
        return rentedHours;
    }
    public int getMinutesOverHour() {
        return minutesOverHour;
    }
    public int getPrice() {
        return price;
    }
}
