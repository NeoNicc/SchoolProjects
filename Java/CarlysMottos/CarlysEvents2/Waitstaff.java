import javax.swing.JOptionPane;

public class Waitstaff extends Employee {
    final double payCap = 10.00;
    public void setPayRate(double rate) {
        if (rate < payCap) {
            this.payRate = rate;
        } else {
            JOptionPane.showMessageDialog(null, "That rate is out of bounds for Waitstaff. Choose between 0 and 10");
        }
    }
    public void setJobTitle() {
        this.jobTitle = "Waitstaff";
    }
}
