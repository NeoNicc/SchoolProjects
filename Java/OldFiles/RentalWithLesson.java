public class RentalWithLesson extends Rental {
    private int type;
    private boolean lessonRequired;

    final static String[] equipment = {"Personal Watercraft", "Pontoon Boat", "Water Skiis", "Big Float", "JetSki", "Tube", "Snorkel Gear", "Fishing Pole"};
    
    final static String[] instructors = {"Professor Plum", "Colonel Mustard", "Ms. Green", "Mrs. Scarlet", "Prof. Peacock", "Dr. Whitely", "Reverand Black", "Sir Grey"};

    RentalWithLesson(String contractNum, int minutes, int type) {
        super(contractNum, minutes);
        this.type = type;

        if (this.type == 0 || this.type == 1) {
            this.lessonRequired = true;
        } else {
            this.lessonRequired = false;
        }
    }

    public int getType() {
        return type;
    }
    public String getEquipment() {
        return equipment[type - 1];
    }
    public String getInstructor() {
        String phrase;
        if(lessonRequired == true) {
            phrase = "Your " + this.getType() + " requires a lesson.\nYour instructor will be " + instructors[type - 1];
        } else {
            phrase = "Your " + this.getEquipment() + " does not require a lesson.\nThe instructor should you so choose to take a lesson would be " + instructors[type - 1];
        }
        return phrase;
    }
}
