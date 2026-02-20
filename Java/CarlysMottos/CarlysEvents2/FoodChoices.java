//continue from line 32 trying to 
//make the frame appear when an
//entree is selected

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FoodChoices extends JFrame implements ActionListener {
    private final int WIDTH = 500;
    private final int HEIGHT = 400;

    private int boxesChecked = 0;
    private String entree = null;
    private String side1 = null;
    private String side2 = null;
    private String dessert = null;
    private int price = 0;
    
    private JLabel inputLabel = new JLabel("Enter number of guests");
    private JTextField guestNumInput;
    private ButtonGroup entreeGroup = new ButtonGroup();
    private JCheckBox[] entrees = new JCheckBox[4];
    private ButtonGroup sideGroup = new ButtonGroup();
    private JCheckBox[] sides = new JCheckBox[5];
    private ButtonGroup dessertGroup = new ButtonGroup();
    private JCheckBox[] desserts = new JCheckBox[4];
    private JButton submitButton = new JButton("Submit");
    private JTextArea foodChoices;

    private String foodString = "Food Cost: $35 / person\n";

    public FoodChoices(String titleString) {
        super(titleString);
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font biggerText = new Font("Times New Roman", Font.PLAIN, 20);

        inputLabel.setFont(biggerText);
        add(inputLabel);
        inputLabel.setVisible(true);

        guestNumInput = new JTextField(3);
        guestNumInput.setFont(biggerText);
        add(guestNumInput);
        guestNumInput.setVisible(true);

        //initializing checkbox arrays full of checkboxes 
        //array1 entrees
        for (int a = 0; a < 4; a++) {
            entrees[a] = new JCheckBox();
            entreeGroup.add(entrees[a]);
            entrees[a].addActionListener(this);
            add(entrees[a]);
            entrees[a].setVisible(false);
            switch (a) {
                case 0:
                    entrees[a].setText("Grilled Salmon");
                    break;
                case 1:
                    entrees[a].setText("Chicken Parmesan");
                    break;
                case 2:
                    entrees[a].setText("Vegetable Dumplings");
                    break;
                case 3:
                    entrees[a].setText("Lasagna");
                    break;
                default:
                    break;
            }
        }
        //array2 sides
        for (int b = 0; b < 5; b++) {
            sides[b] = new JCheckBox();
            sideGroup.add(sides[b]);
            sides[b].addActionListener(this);
            add(sides[b]);
            sides[b].setVisible(false);
            switch (b) {
                case 0:
                    sides[b].setText("Mashed Potatoes");
                    break;
                case 1:
                    sides[b].setText("Grilled Asparagus");
                    break;
                case 2:
                    sides[b].setText("Fried Rice and Veggies");
                    break;
                case 3:
                    sides[b].setText("Macaroni and Cheese");
                    break;
                case 4:
                    sides[b].setText("Street Tacos");
                    break;
                default:
                    break;
            }
        }
        //array3 dessert
        for (int c = 0; c < 4; c++) {
            desserts[c] = new JCheckBox();
            dessertGroup.add(desserts[c]);
            desserts[c].addActionListener(this);
            add(desserts[c]);
            desserts[c].setVisible(false);
            switch (c) {
                case 0:
                    desserts[c].setText("Decadent Double Chocolate Molten Lava Cake");
                    break;
                case 1:
                    desserts[c].setText("Orange Cream Sherbert w/ Toppings assortment");
                    break;
                case 2:
                    desserts[c].setText("1-Quart Ziplock bag full of Peanut M&Ms");
                    break;
                case 3: 
                    desserts[c].setText("Fruit Charcuterie with Cottage Cheese or Greek Yogurt");
                default:
                    break;
            }
        }

        submitButton.setFont(biggerText);
        submitButton.setPreferredSize(new Dimension(120,35));
        submitButton.addActionListener(this);
        add(submitButton);
        submitButton.setVisible(true);

        foodChoices = new JTextArea(foodString);
        foodChoices.setPreferredSize(new Dimension(390, 300));
        foodChoices.setLineWrap(true);
        foodChoices.setWrapStyleWord(true);
        foodChoices.setFont(biggerText);
        add(foodChoices);
        foodChoices.setVisible(false);

        setVisible(true);
    }

    public void setGroupVisible(JCheckBox[] group, boolean b) {
        for (int f = 0; f < group.length; f++) {
            group[f].setVisible(b);
        }
    }

    public void score(JCheckBox[] group) {
        String[] entreesList = {"Grilled Salmon", "Chicken Parmesan", "Veggetable Dumplings", "Lasagna"};
        String[] sidesList = {"Mashed Potatoes", "Grilled Asparagus", "Fried Rice and Veggies", "Macaroni and Cheese", "Street Tacos"};
        String[] dessertsList = {"Decadent Double Chocolate Molten Lava Cake", "Orange Cream Sherbert w/ Toppings assortment", "1-Quart Ziplock bag full of Peanut M&Ms", "Fruit Charcuterie with Cottage Cheese or Greek Yogurt"};

        if (group[0].getText().equals(entreesList[0])) {
            for (int g = 0; g < group.length; g++) {
                if (group[g].isSelected() == true) {
                    entree = entreesList[g];
                    foodChoices.append("\nEntree: " + entree);
                } 
            }
        } else if (group[0].getText().equals(sidesList[0]) && side1 == null) {
            for (int g = 0; g < group.length; g++) {
                if (group[g].isSelected() == true) {
                    side1 = sidesList[g];
                    foodChoices.append("\nSide (1/2): " + side1);
                } 
            }
        } else if (group[0].getText().equals(sidesList[0]) && side1 != null) {
            for (int g = 0; g < group.length; g++) {
                if (group[g].isSelected() == true) {
                    side2 = sidesList[g];
                    foodChoices.append("\nSide (2/2): " + side2);
                } 
            }
        } else if (group[0].getText().equals(dessertsList[0])) {
            for (int g = 0; g < group.length; g++) {
                if (group[g].isSelected() == true) {
                    dessert = dessertsList[g];
                    foodChoices.append("\nDessert: " + dessert);
                } 
            }
        }
    }

    public void calculatePrice() {
        int guests;
        try {
            guests = Integer.parseInt(guestNumInput.getText());
        } catch (Exception e) {
            guests = 0;
        }
        
        price = 35 * guests;
        foodChoices.append("\nTotal Cost: $" + price + "\n\nThank You For Catering with us!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == submitButton) {
            System.out.println("line 190: SubmitButton");
            if (guestNumInput.isVisible() == true) {
                System.out.println("line 192: guestcount enter");
                inputLabel.setText("Choose an Entree");
                foodChoices.append("Guests: " + guestNumInput.getText() + "\n\nFood Choices: ");
                guestNumInput.setVisible(false);
                setGroupVisible(entrees, true);
                foodChoices.setVisible(true);
                revalidate();
                repaint();
            } else if (entrees[0].isVisible() == true) {
                System.out.println("line198: entrees check");
                score(entrees);
                inputLabel.setText("Choose a Side (1/2)");
                setGroupVisible(entrees, false);
                setGroupVisible(sides, true);
            } else if (sides[0].isVisible() == true && side1 == null) {
                System.out.println("line204 side1 check");
                score(sides);
                inputLabel.setText("Choose a Side (2/2)");
            } else if (sides[0].isVisible() == true && side1 != null) {
                score(sides);
                inputLabel.setText("Choose a Dessert");
                setGroupVisible(sides, false);
                setGroupVisible(desserts, true);
            } else if (desserts[0].isVisible() == true && dessert == null) {
                score(desserts);
                inputLabel.setText("Event Receipt");
                setGroupVisible(desserts, false);
                submitButton.setVisible(false);
                calculatePrice();
            }
            //just keep making these elseif statements
            //for each set of choices 
            //then do some logic for the price
            //in a calculate price function
            //then display the results only and let the checkboxes
            //and label dissappear
        } 
    }
}
