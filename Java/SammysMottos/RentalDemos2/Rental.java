public class Rental {
    public final static int minutesInHour = 60;
    public final static int ratePerHour = 40;

    private String contractNum;
    private int rentedHours;
    private int minutesOverHour;
    private int price;
    private Equipment equipment;
    private int equipBasePrice;

    public Rental(String contractNum, int minutes, String equipmentType) {
        setContractNum(contractNum);
        setHoursAndMinutes(minutes);
        String[] listOfEquipment = Equipment.getEquipmentNames();
        for (int i = 0; i < (listOfEquipment.length); i++) {
            if (i < 5) {
                if (equipmentType.equals(listOfEquipment[i])) {
                    this.equipment = new EquipmentWithLesson(equipmentType);
                }
            } else if (i < listOfEquipment.length) {
                if (equipmentType.equals(listOfEquipment[i])) {
                    this.equipment = new EquipmentWithoutLesson(equipmentType);
                }
            } else {
                this.equipment = new EquipmentWithoutLesson("Other...");
            }
        }
        this.price += equipment.getEquipmentFee();
    }
    public Rental() {
        this("A000", 0, "Other...");
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }
    public void setHoursAndMinutes(int minutes) {
        this.rentedHours = minutes / minutesInHour;
        this.minutesOverHour = minutes % minutesInHour;
        this.price = (rentedHours * ratePerHour) + minutesOverHour;
        this.equipBasePrice = 20;
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
    public Equipment getEquipment() {
        return equipment;
    }
}
