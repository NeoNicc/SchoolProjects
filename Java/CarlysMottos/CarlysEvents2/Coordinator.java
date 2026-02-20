import javax.swing.JOptionPane;

public class Coordinator extends Employee {
    private final double payCap = 20.00;

    public void setPayRate(double rate) {
        if (rate < payCap) {
            this.payRate = rate;
        } else {
            JOptionPane.showMessageDialog(null, "That rate is out of bounds for Coordinators. Choose between 0 and 20");
        }
    }
    public void setJobTitle() {
        this.jobTitle = "Coordinator";
    }
}
