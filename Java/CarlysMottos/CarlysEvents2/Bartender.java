import javax.swing.JOptionPane;

public class Bartender extends Employee {
    private final double payCap = 14.00;
    public void setPayRate(double rate) {
        if (rate < payCap) {
            this.payRate = rate;
        } else {
            JOptionPane.showMessageDialog(null, "That rate is out of bounds for Bartenders. Choose between 0 and 14");
        }
    }
    public void setJobTitle() {
        this.jobTitle = "Bartender";
    }
}
