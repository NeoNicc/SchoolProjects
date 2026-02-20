import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;

public class SammysFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private int page = 0;
    private String equip = "";
    private int equipPrice = 0;
    private int total = 0;
    private boolean hasLesson = false;
    private int timeRented = 0;
    private int hours = 0;
    private int minutes = 0;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(grid,500,400);
        String cssPath = getClass().getResource("sammysStyles.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        primaryStage.setTitle("Sammy's");
        primaryStage.setScene(scene);
        FlowPane radioButtFlow = new FlowPane();
        radioButtFlow.setHgap(10);
        radioButtFlow.setVgap(10);

        Label prompt = new Label("Rental Duration (in Minutes)");
        grid.add(prompt, 1, 2, 2, 1);

        TextField minutesRentedInput = new TextField();
        minutesRentedInput.setPrefColumnCount(3);
        grid.add(minutesRentedInput, 3, 2, 1, 1);

        ToggleGroup equipmentGroup = new ToggleGroup();
        RadioButton[] equipment = new RadioButton[7];
        for(int a = 0; a < equipment.length; a++) {
            equipment[a] = new RadioButton();
            equipment[a].setToggleGroup(equipmentGroup);
            equipment[a].setPrefSize(175, 40);
            switch (a) {
                case 0:
                    equipment[a].setText("Waterjetski $40");
                    equipment[a].setSelected(true);
                    break;
                case 1:
                    equipment[a].setText("Pontoon Boat $40");
                    break;
                case 2:
                    equipment[a].setText("Rowboat $20");
                    break;
                case 3: 
                    equipment[a].setText("Canoe $20");
                    break;
                case 4: 
                    equipment[a].setText("Kayak $20");
                    break;
                case 5:
                    equipment[a].setText("Beach Chair $7");
                    break;
                case 6:
                    equipment[a].setText("umbrella $7");
                    break;
                default:
                    break;
            }
        }
        //HBox equipmentHBox = new HBox(10, equipment);
        radioButtFlow.getChildren().addAll(equipment);
        grid.add(radioButtFlow, 1, 3, 2, 1);
        radioButtFlow.setVisible(false);
        radioButtFlow.setManaged(false);

        ToggleGroup lessonGroup = new ToggleGroup();
        RadioButton[] lessons = new RadioButton[2];
        for(int a = 0; a < 2; a++) {
            lessons[a] = new RadioButton();
            lessons[a].setToggleGroup(lessonGroup);
            lessons[a].setPrefSize(100, 40);
            switch (a) {
                case 0:
                    lessons[a].setText("Yes");
                    break;
                case 1:
                    lessons[a].setText("No");
                    lessons[a].setSelected(true);
                    break;
                default:
                    break;
            }
        }
        HBox lessonHBox = new HBox(10, lessons);
        grid.add(lessonHBox, 1, 3, 4, 1);
        lessonHBox.setVisible(false);
        lessonHBox.setManaged(false);

        TextArea receipt = new TextArea("Equipment: ");
        //receipt.setPrefSize(280, 250);
        receipt.setVisible(false);
        receipt.setManaged(false);
        grid.add(receipt, 1, 3, 2, 1);

        Button submitButton = new Button("Submit");
        submitButton.setPrefSize(100, 40);
        grid.add(submitButton, 1, 3);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch(page) {
                    case 0:
                        minutesRentedInput.setVisible(false);
                        prompt.setText("Which piece of equipment would you like to rent?");
                        GridPane.setRowIndex(submitButton, 4);
                        radioButtFlow.setVisible(true);
                        radioButtFlow.setManaged(true);
                        page += 1;
                        break;
                    case 1:
                        radioButtFlow.setVisible(false);
                        radioButtFlow.setManaged(false);
                        try {
                            timeRented += Integer.parseInt(minutesRentedInput.getText());
                        } catch (Exception e) {
                            timeRented += 0;
                        }
                        hours = timeRented / 60;
                        minutes = timeRented % 60;
                        for (int a = 0; a < equipment.length; a++) {
                            if (equipment[a].isSelected() == true) {
                                switch (a) {
                                    case 0:
                                        equip = "Waterjetski";
                                        equipPrice += 40;
                                        total += 40;
                                        break;
                                    case 1:
                                        equip = "Pontoon Boat";
                                        equipPrice += 40;
                                        total += 40;
                                        break;
                                    case 2:
                                        equip = "Rowboat";
                                        equipPrice += 20;
                                        total += 20;
                                        break;
                                    case 3:
                                        equip = "Canoe";
                                        equipPrice += 20;
                                        total += 20;
                                        break;
                                    case 4:
                                        equip = "Kayak";
                                        equipPrice += 20;
                                        total += 20;
                                        break;
                                    case 5:
                                        equip = "Beach Chair";
                                        equipPrice += 7;
                                        total += 7;
                                        break;
                                    case 6:
                                        equip = "Umbrella";
                                        equipPrice += 7;
                                        total += 7;
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        prompt.setText("Would you like a lesson? $5");
                        if (equipment[5].isSelected() == true || equipment[6].isSelected() == true) {
                            lessons[0].setDisable(true);
                        }
                        lessonHBox.setVisible(true);
                        lessonHBox.setManaged(true);
                        page += 1;
                        break;
                    case 2:
                        lessonHBox.setVisible(false);
                        lessonHBox.setManaged(false);
                        if (lessons[0].isSelected() == true) {
                            hasLesson = true;
                            total += 5;
                        }
                        prompt.setText("Receipt");
                        if (hasLesson == false) {
                            receipt.appendText(equip + "\nPrice/Hr: $" + equipPrice + "\nDuration Rented: " + hours + " hours and " + minutes + " minutes\n\nTotal: $" + total + "\nThanks for renting with Sammy");
                        } else {
                            receipt.appendText(equip + "\nPrice/Hr: $" + equipPrice + "\nDuration Rented: " + hours + " hours and " + minutes + " minutes\nLesson Taken ($5)\n\nTotal: $" + total + "\nThanks for renting with Sammy");
                        }
                        submitButton.setText("Quit");
                        receipt.setVisible(true);
                        receipt.setManaged(true);
                        page += 1;
                        break;
                    case 3:
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
