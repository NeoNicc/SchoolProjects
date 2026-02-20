import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JSammys extends JFrame implements ActionListener {
    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    boolean lessonTaken = false;

    private JLabel rentalLabel = new JLabel("Rental duration in minutes");
    private JTextField timeInput = new JTextField(3);
    private ButtonGroup equipmentGroup = new ButtonGroup();
    private JCheckBox[] equipment = new JCheckBox[7];
    private ButtonGroup lessonGroup = new ButtonGroup();
    private JCheckBox[] lesson = new JCheckBox[2];
    private JTextArea receipt = new JTextArea("Equipment Rented: ");
    private JButton submitButton = new JButton("Submit");

    Font biggerText = new Font("Times New Roman", Font.PLAIN,24);

    public JSammys(String titleString) {
        super(titleString);
        setLayout(new FlowLayout());
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        rentalLabel.setFont(biggerText);
        rentalLabel.setVisible(true);
        add(rentalLabel);

        timeInput.setFont(biggerText);
        timeInput.setVisible(true);
        add(timeInput);

        for (int a = 0; a < equipment.length; a++) {
            equipment[a] = new JCheckBox();
            equipment[a].setFont(biggerText);
            equipment[a].setVisible(false);
            switch (a) {
                case 0:
                    equipment[a].setText("Personal Watercraftski - $40/hr");
                    equipment[a].setSelected(true);
                    break;
                case 1:
                    equipment[a].setText("Pontoon Boat - $40/hr");
                    break;
                case 2:
                    equipment[a].setText("Rowboat - $20/hr");
                    break;
                case 3:
                    equipment[a].setText("Canoe - $20/hr");
                    break;
                case 4:
                    equipment[a].setText("Kayak - $20/hr");
                    break;
                case 5:
                    equipment[a].setText("Beach Chair - $7/hr");
                    break;
                case 6:
                    equipment[a].setText("Umbrella - $7/hr");
                    break;
                default:
                    break;
            }
            equipmentGroup.add(equipment[a]);
            add(equipment[a]);
        }

        for (int b = 0; b < lesson.length; b++) {
            lesson[b] = new JCheckBox();
            lesson[b].setFont(biggerText);
            lesson[b].setVisible(false);
            switch (b) {
                case 0:
                    lesson[b].setText("Yes");
                    break;
                case 1:
                    lesson[b].setText("No");
                    lesson[b].setSelected(true);
                    break;
                default:
                    break;
            }
            lessonGroup.add(lesson[b]);
            add(lesson[b]);
        }

        receipt.setPreferredSize(new Dimension(390, 280));
        receipt.setFont(biggerText);
        receipt.setLineWrap(true);
        receipt.setWrapStyleWord(true);
        receipt.setVisible(false);
        add(receipt);

        submitButton.setFont(biggerText);
        submitButton.setPreferredSize(new Dimension(120, 30));
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    public void setGroupVisible(JCheckBox[] group, boolean isVisible) {
        for (int c = 0; c < group.length; c++) {
            group[c].setVisible(isVisible);
        }
    }

    public void calculateReceipt() {
        int total = 0;
        int rentalTime;
        String equipRented = "nothing";

        try {
            rentalTime = Integer.parseInt(timeInput.getText());
        } catch (Exception e) {
            rentalTime = 0;
        }
        
        int[] prices = {40, 40, 20, 20, 20, 7, 7};
        
        for(int f = 0; f < equipment.length; f++) {
            if (equipment[f].isSelected()) {
                total += (prices[f] * (rentalTime / 60));
                System.out.println(total + " first total for rental selection");
                equipRented = equipment[f].getText();
            }
        }

        for (int g = 0; g < lesson.length; g++) {
            if (lesson[g].isSelected()) {
                if (g == 0) {
                    total += 5;
                    lessonTaken = true;
                }
            }
        }

        if (lessonTaken == true) {
            receipt.append(equipRented + "\nRental Duration: " + rentalTime/60 + "hours and " + rentalTime%60 + " minutes.\nLesson: Yes\nTotal: $" + total + "\nThank for renting from Sammy's");
        receipt.setVisible(true);
        } else {
            receipt.append(equipRented + "\nRental Duration: " + rentalTime/60 + "hours and " + rentalTime%60 + " minutes.\nLesson: No\nTotal: $" + total + "\nThank for renting from Sammy's");
        receipt.setVisible(true);
        }

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (timeInput.isVisible() == true) {
            timeInput.setVisible(false);
            setGroupVisible(equipment, true);
            rentalLabel.setText("Choose what you would like to rent");
            revalidate();
            repaint();
        } else if (equipment[0].isVisible() == true) {
            setGroupVisible(equipment, false);
            setGroupVisible(lesson, true);
            rentalLabel.setText("Would you like a lesson? $5");
            if (equipment[5].isSelected() == true || equipment[6].isSelected() == true) {
                lesson[0].setEnabled(false);
            }
            revalidate();
            repaint();
        } else if (lesson[0].isVisible() == true) {
            setGroupVisible(lesson, false);
            submitButton.setVisible(false);
            rentalLabel.setText("Receipt");
            calculateReceipt();
            revalidate();
            repaint();
        }
    }
}
