import java.awt.Font;

import javax.swing.Action;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;

public class MathJavaFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    //Start method where most code goes
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Label label = new Label("Can you add and Subtract?");
        grid.add(label, 1,1,3,1);
        TextField operand1 = new TextField();
        operand1.setPrefColumnCount(3);
        TextField operand2 = new TextField();
        operand2.setPrefColumnCount(3);
        Image equalsImage = new Image(getClass().getResourceAsStream("equalSign.png"));
        ImageView equals = new ImageView(equalsImage);
        equals.setFitWidth(50);
        equals.setFitHeight(50);
        TextField answer = new TextField();
        answer.setPrefColumnCount(6);
        GridPane.setHalignment(equals, HPos.CENTER);
        GridPane.setHalignment(answer, HPos.CENTER);

        ToggleGroup operatorGroup = new ToggleGroup();
        RadioButton plus = new RadioButton();
        Image plusImage = new Image(getClass().getResourceAsStream("plusIcon.png"));
        ImageView plusView = new ImageView(plusImage);
        plusView.setFitWidth(30);
        plusView.setFitHeight(30);
        plus.setGraphic(plusView);
        plus.setSelected(true);
        plus.setToggleGroup(operatorGroup);
        RadioButton minus = new RadioButton();
        Image minusImage = new Image(getClass().getResourceAsStream("minusIcon.png"));
        ImageView minusView = new ImageView(minusImage);
        minusView.setFitWidth(30);
        minusView.setFitHeight(30);
        minus.setGraphic(minusView);
        minus.setToggleGroup(operatorGroup);
        HBox operatorBox = new HBox(10, plus, minus);
        Button btn = new Button();
        Button quitButton = new Button(); 
        Button replayButton = new Button();
        grid.add(quitButton, 3, 3);
        GridPane.setHalignment(quitButton, HPos.RIGHT);
        grid.add(replayButton, 2, 3);
        quitButton.setPrefWidth(100);
        replayButton.setPrefWidth(100);
        quitButton.setVisible(false);
        replayButton.setVisible(false);
        

        //try again button
        replayButton.setText("Replay");
        replayButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                quitButton.setVisible(false);
                replayButton.setVisible(false);

                operand1.setText("");
                operand1.setVisible(true);
                equals.setVisible(true);
                operand2.setText("");
                operand2.setVisible(true);
                operatorBox.setVisible(true);
                GridPane.setColumnIndex(answer, 3);
                GridPane.setColumnSpan(answer, 1);
                answer.setText("");
                answer.setPrefColumnCount(6);
                answer.setEditable(true);
                answer.setVisible(true);
                btn.setVisible(true);
            }
        });

        //Quit button 
        quitButton.setText("Quit");
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });

        //start of button widget addition
        
        btn.setText("Check Answer");
        //event handler for button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //getting which button is selected for the operation
                String operator = "-";
                if (plus.isSelected() == true) {
                    operator = "+";
                }
                //System.out.println(operator + "something");
                if (operator.equals("+")) {
                    //System.out.println("+");
                    //code for addition
                    int op1;
                    int op2;
                    int ans;
                    try {
                        op1 = Integer.parseInt(operand1.getText());
                    } catch (Exception e) {
                        op1 = 0;
                    }
                    try {
                        op2 = Integer.parseInt(operand2.getText());
                    } catch (Exception e) {
                        op2 = 0;
                    }
                    try {
                        ans = Integer.parseInt(answer.getText());
                    } catch (Exception e) {
                        ans = 1;
                    }
                    
                    if (op1 + op2 == ans) {
                        answer.setPrefColumnCount(16);
                        GridPane.setColumnSpan(answer, 2);
                        answer.setText("YOU GOT IT CORRECT");
                        answer.setEditable(false);
                        answer.setFocusTraversable(false);
                    } else {
                        answer.setPrefColumnCount(16);
                        GridPane.setColumnSpan(answer, 2);
                        answer.setText("BETTER LUCK NEXT TIME");
                        answer.setEditable(false);
                        answer.setFocusTraversable(false);
                    }
                } else if (operator.equals("-")) {
                    //code for subtraction
                    int op1;
                    int op2;
                    int ans;
                    try {
                        op1 = Integer.parseInt(operand1.getText());
                    } catch (Exception e) {
                        op1 = 0;
                    }
                    try {
                        op2 = Integer.parseInt(operand2.getText());
                    } catch (Exception e) {
                        op2 = 0;
                    }
                    try {
                        ans = Integer.parseInt(answer.getText());
                    } catch (Exception e) {
                        ans = 1;
                    }
                    
                    if (op1 - op2 == ans) {
                        answer.setPrefColumnCount(20);
                        GridPane.setColumnSpan(answer, 2);
                        answer.setText("YOU GOT IT CORRECT");
                        answer.setEditable(false);
                    } else {
                        answer.setPrefColumnCount(20);
                        GridPane.setColumnSpan(answer, 2);
                        answer.setText("BETTER LUCK NEXT TIME");
                        answer.setEditable(false);
                    }
                }

                GridPane.setColumnIndex(answer, 2);
                operand1.setVisible(false);
                operand2.setVisible(false);
                equals.setVisible(false);
                operatorBox.setVisible(false);
                btn.setVisible(false);
                replayButton.setVisible(true);
                quitButton.setVisible(true);
                //System.out.println("hello");
            }
        });

        
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        grid.add(btn, 2, 6, 2, 1);
        grid.add(answer, 3, 5);
        grid.add(equals, 2, 5);
        grid.add(operand2, 3, 3);
        
        grid.add(operatorBox, 2, 3);
        grid.add(operand1, 3, 2);

        Scene scene = new Scene(grid,350,300);
        String cssPath = getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(cssPath);

        primaryStage.setTitle("My First JavaFX App!!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
