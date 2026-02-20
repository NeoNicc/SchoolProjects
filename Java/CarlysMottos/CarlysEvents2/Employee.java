public abstract class Employee {
    private int idNum;
    private String lastName;
    private String firstName;
    protected double payRate;
    protected String jobTitle;

    public int getIDNum() {
        return idNum;
    }
    public void setIDNum(int num) {
        this.idNum = num;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public double getPayRate() {
        return payRate;
    }
    public abstract void setPayRate(double rate);
    
    public String getJobTitle() {
        return jobTitle;
    }
    public abstract void setJobTitle();
}
