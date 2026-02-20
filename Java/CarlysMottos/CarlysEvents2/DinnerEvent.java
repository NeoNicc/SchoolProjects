import javax.swing.JOptionPane;

public class DinnerEvent extends Event {
    //create list of employees
    public Employee[] employees = new Employee[15];
    //A whole meal
    private int entree;
    private int sideOne;
    private int sideTwo;
    private int dessert;
    //delicious meal options
    final static String[] entrees = {"Grilled Salmon", "Chicken Parmesan", "Veggetable Dumplings", "Lasagna"};
    final static String[] sides = {"Mashed Potatoes", "Grilled Asparagus", "Fried Rice and Veggies", "Macaroni and Cheese", "Street Tacos"};
    final static String[] desserts = {"Decadent Double Chocolate Molten Lava Cake", "Orange Cream Sherbert w/ Toppings assortment", "1-Quart Ziplock bag full of Peanut M&Ms", "Fruit Charcuterie with Cottage Cheese or Greek Yogurt"};

    DinnerEvent(String eventNum, int guestCount, int entree, int sideOne, int sideTwo, int dessert) {
        super(eventNum, guestCount);
        this.entree = entree;
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.dessert = dessert;
    }

    //return a String describing selections as the Meal
    public String getMenu() {
        String phrase = "Menu:\nEntree: " + entrees[entree] + "\nSide 1/2: " + sides[sideOne] + "\nSide 2/2: " + sides[sideTwo] + "\nDessert: " + desserts[dessert];

        return phrase;
    }

    //return the current list of potential employees 
    public Employee[] getEmployees() {
        return employees;
    }
    public String displayEmployees() {
        String phrase = "";
        for(int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                phrase += "Job title: ";
                phrase += employees[i].getJobTitle();
                phrase += "\nName: ";
                phrase += employees[i].getFirstName();
                phrase += " ";
                phrase += employees[i].getLastName();
                phrase += "\nPay rate: ";
                phrase += employees[i].getPayRate();
                phrase += "\nEmployeeID: ";
                phrase += employees[i].getIDNum();
                phrase += "\n";
            }
        }
        return phrase;
    }
    public void setEmployees(int guests) {
        int waitstaff = 1;
        int bartender = 0;
        int coordinator = 1;
        
        waitstaff += (int)(Math.floor((guests/10)));
        bartender += (int)(Math.floor((guests/25)));

        int index = 0;
        for (int i = 0; i < waitstaff; i++) {
            for (int j = 0; j < bartender; j++) {
                for (int k = 0; k < coordinator; k++) {
                    employees[index] = new Coordinator();
                    employees[index].setIDNum(requestIDNum());
                    employees[index].setLastName(requestLastName());
                    employees[index].setFirstName(requestFirstName());
                    employees[index].setJobTitle();
                    JOptionPane.showMessageDialog(null, employees[index].getJobTitle());
                    employees[index].setPayRate(requestPayRate());

                    coordinator--;
                    index++;
                }
                employees[index] = new Bartender();
                employees[index].setIDNum(requestIDNum());
                employees[index].setLastName(requestLastName());
                employees[index].setFirstName(requestFirstName());
                employees[index].setJobTitle();
                JOptionPane.showMessageDialog(null, employees[index].getJobTitle());
                employees[index].setPayRate(requestPayRate());

                bartender--;
                index++;
            }
            employees[index] = new Waitstaff();
            employees[index].setIDNum(requestIDNum());
            employees[index].setLastName(requestLastName());
            employees[index].setFirstName(requestFirstName());
            employees[index].setJobTitle();
            JOptionPane.showMessageDialog(null, employees[index].getJobTitle());
            employees[index].setPayRate(requestPayRate());

            waitstaff--;
            index++;
        }
    }

    //asks user for employee id number
    public static int requestIDNum() {
        while(true) {
            try {
                String idInput = JOptionPane.showInputDialog(null, "Enter a number for the Employee ID");
                int parsedInput = Integer.parseInt(idInput);
                return parsedInput;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid whole number");
            }
        }
    }

    //asks user for employee last name
    public static String requestLastName() {
        String lastNameInput = JOptionPane.showInputDialog(null, "What is the Employee's last name?");
        return lastNameInput;
    }

    //asks user for employee first name
    public static String requestFirstName() {
        String firstNameInput = JOptionPane.showInputDialog(null, "What is the Employee's first name?");
        return firstNameInput;
    }

    //asks user for employee pay rate
    public static double requestPayRate() {
        while (true) {
            try {
                String payRateInput = JOptionPane.showInputDialog(null, "What is the Employee's pay rate? Type xx.xx");
                double parsedPayRate = Double.parseDouble(payRateInput);

                return parsedPayRate;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number with up to 2 decimals. XX.XX");
            }
        }
        
    }
}
