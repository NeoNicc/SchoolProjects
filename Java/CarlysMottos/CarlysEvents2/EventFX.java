import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;

public class EventFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private int page = 0;
    private String entree = "";
    private String side1 = "";
    private String side2 = "";
    private String dessert = "";
    private int total = 0;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(grid,500,500);
        String cssPath = getClass().getResource("eventStyles.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        primaryStage.setTitle("Carlys Catering");
        primaryStage.setScene(scene);

        Label prompt = new Label("How many guests shall attend?");
        grid.add(prompt, 1, 2, 2, 1);

        TextField guestCountInput = new TextField();
        guestCountInput.setPrefColumnCount(3);
        grid.add(guestCountInput, 3, 2, 1, 1);

        ToggleGroup entreeGroup = new ToggleGroup();
        RadioButton[] entrees = new RadioButton[4];
        for(int a = 0; a < 4; a++) {
            entrees[a] = new RadioButton();
            entrees[a].setToggleGroup(entreeGroup);
            entrees[a].setPrefSize(200, 100);
            switch (a) {
                case 0:
                    entrees[a].setText("Grilled Salmon");
                    entrees[a].setSelected(true);
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
        HBox entreeHBox = new HBox(10, entrees);
        grid.add(entreeHBox, 1, 3, 4, 1);
        entreeHBox.setVisible(false);

        ToggleGroup sideGroup = new ToggleGroup();
        RadioButton[] sides = new RadioButton[5];
        for(int a = 0; a < 5; a++) {
            sides[a] = new RadioButton();
            sides[a].setToggleGroup(sideGroup);
            sides[a].setPrefSize(200, 100);
            switch (a) {
                case 0:
                    sides[a].setText("Mashed Potatoes");
                    sides[a].setSelected(true);
                    break;
                case 1:
                    sides[a].setText("Grilled Asparagus");
                    break;
                case 2:
                    sides[a].setText("Fried Rice");
                    break;
                case 3: 
                    sides[a].setText("Mac n' Cheese");
                    break;
                case 4:
                    sides[a].setText("Street Tacos");
                    break;
                default:
                    break;
            }
        }
        HBox sideHBox = new HBox(10, sides);
        grid.add(sideHBox, 1, 3, 4, 1);
        sideHBox.setVisible(false);

        ToggleGroup dessertGroup = new ToggleGroup();
        RadioButton[] desserts = new RadioButton[4];
        for(int a = 0; a < 4; a++) {
            desserts[a] = new RadioButton();
            desserts[a].setToggleGroup(dessertGroup);
            desserts[a].setPrefSize(200, 100);
            switch (a) {
                case 0:
                    desserts[a].setText("Lava Cake");
                    desserts[a].setSelected(true);
                    break;
                case 1:
                    desserts[a].setText("Orange Sherbet");
                    break;
                case 2:
                    desserts[a].setText("1lb bag of M&M's");
                    break;
                case 3: 
                    desserts[a].setText("Fruit Charcuterie");
                    break;
                default:
                    break;
            }
        }
        HBox dessertHBox = new HBox(10, desserts);
        grid.add(dessertHBox, 1, 3, 4, 1);
        dessertHBox.setVisible(false);

        TextArea receipt = new TextArea("Cost per person: $35\n\nMeal Selections: \n");
        receipt.setVisible(false);

        Button submitButton = new Button("Submit");
        submitButton.setPrefSize(100, 40);
        grid.add(submitButton, 1, 3);
        GridPane.setHalignment(submitButton, HPos.CENTER);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch (page) {
                    case 0:
                        guestCountInput.setVisible(false);
                        prompt.setText("Select an Entree");
                        entreeHBox.setVisible(true);
                        GridPane.setRowIndex(submitButton, 4);
                        page += 1;
                        break;
                    case 1: 
                        for (int b = 0; b < 4; b++) {
                            if(entrees[b].isSelected()) {
                                entree = entrees[b].getText();
                            }
                        }
                        prompt.setText("Select a Side (1/2)");
                        entreeHBox.setVisible(false);
                        sideHBox.setVisible(true);
                        page += 1;
                        break;
                    case 2:
                        for (int b = 0; b < 5; b++) {
                            if(sides[b].isSelected()) {
                                side1 = sides[b].getText();
                            }
                        }
                        prompt.setText("Select a Side (2/2)");
                        sides[0].setSelected(true);
                        page += 1;
                        break;
                    case 3:
                        for (int b = 0; b < 5; b++) {
                            if(sides[b].isSelected()) {
                                side2 = sides[b].getText();
                            }
                        }
                        prompt.setText("Select a Dessert");
                        sideHBox.setVisible(false);
                        dessertHBox.setVisible(true);
                        page += 1;
                        break;
                    case 4:
                        try {
                            total = (Integer.parseInt(guestCountInput.getText()) * 35);
                        } catch (Exception e) {
                            total = 0;
                        }
                        for (int b = 0; b < 4; b++) {
                            if(desserts[b].isSelected()) {
                                dessert = desserts[b].getText();
                            }
                        }
                        prompt.setText("Receipt");
                        receipt.appendText(entree + "\n" + side1 + "\n" + side2 + "\n" + dessert + "\n\nTotal Price: $" + total + "\nThanks For Catering With Carlys");
                        dessertHBox.setVisible(false);
                        grid.add(receipt, 1, 3, 3, 1);
                        receipt.setVisible(true);
                        submitButton.setText("Close");
                        page += 1;
                        break;
                    case 5:
                        Platform.exit();
                        break;
                    default:
                        break;

                }
            }
        });

        primaryStage.show();
    }
}
