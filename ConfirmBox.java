package sample;
import java.lang.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.lang.String;
import java.lang.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ConfirmBox{
    //Create variable
    static boolean answer;

    public static String Randomise()
    {
        int a,b;
        Random rand = new Random();
        a = rand.nextInt(5 + 1 - (-5)) + (-5);
        b = rand.nextInt(5 + 1 - (-5)) + (-5);
        String val, stra, strb;
        if(b<0)
        {
            stra = Integer.toString(a);
            strb = Integer.toString(b);
            val = (stra) + (strb) + "i";
        }
        else if(b==0)
        {
            stra = Integer.toString(a);
            strb = Integer.toString(b);
            val = (stra) + "+" + "i";
        }
        else if(a==0)
        {
            stra = Integer.toString(a);
            strb = Integer.toString(b);
            val = (strb) + "i";
        }
        else {
            stra = Integer.toString(a);
            strb = Integer.toString(b);
            val = (stra) + "+" +
                    (strb) + "i";
        }
        return val;
    }
    public static boolean display(String nameInput, String passLabel) {
        Stage window = new Stage();
        String name, grade;
        name="Name: ";
        grade="Grade: ";
        String nameIn=name+nameInput;
        String gradeIn=grade+passLabel;
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("SAT Practice Demo");
        window.setMinWidth(1080);
        ComplexNumber ans=new ComplexNumber();
        String value=ans.getResult();
        String Ques=ans.getQues();
        Label label = new Label();
        label.setText(gradeIn);

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel=new Label(nameIn);
        nameLabel.setId("boldLabel");
        GridPane.setConstraints(nameLabel, 0, 0);


        Label passInput = new Label(gradeIn);
        passInput.setId("boldLabel");
        GridPane.setConstraints(passInput, 0, 1);

        //Create two buttons
        Button yesButton = new Button("Next ");
        yesButton.getStyleClass().add("buttonBlue");
        GridPane.setConstraints(yesButton, 80, 0);
        Button noButton = new Button("End exam");
        GridPane.setConstraints(noButton, 81, 0);
        //Clicking will set answer and close window


        VBox layout = new VBox();
        layout.setPrefWidth(300);
        layout.setSpacing(20);
        layout.setPadding(new Insets(15,15,15,15));

        VBox radios = new VBox();
        radios.setPrefWidth(300);
        radios.setSpacing(20);
        radios.setPadding(new Insets(15,15,15,15));

        Label question=new Label("1) For i=√-1, what is the sum "+Ques+" ?");
        GridPane.setConstraints(question, 50, 20);

        //Create togglegroup
        ToggleGroup answer1=new ToggleGroup();
        RadioButton a=new RadioButton();
        a.setToggleGroup(answer1);
        a.getStyleClass().add("label");
        RadioButton b=new RadioButton();
        b.setToggleGroup(answer1);
        b.getStyleClass().add("label");
        RadioButton c=new RadioButton();
        c.setToggleGroup(answer1);
        c.getStyleClass().add("label");
        RadioButton d=new RadioButton();
        d.setToggleGroup(answer1);
        d.getStyleClass().add("label");
        RadioButton e=new RadioButton();
        e.setToggleGroup(answer1);
        e.getStyleClass().add("label");
        GridPane.setConstraints(radios, 50, 22);
        //GridPane.setConstraints(no, 50, 47);

        List<RadioButton> givenList = Arrays.asList(a,b,c,d,e);
        Random rand1 = new Random();
        RadioButton randomOption = givenList.get(rand1.nextInt(givenList.size()));
        for (RadioButton bu: givenList) {
            if(bu.equals(randomOption)) {
                bu.setText(value);
            }
            else {
                bu.setText(Randomise());
            }
        }

        for (RadioButton button : givenList) {

            if(button.equals(randomOption)) {
                button.setOnAction(event -> {
                    if(button.isSelected())
                    {
                        System.out.println("\nCorrect Answer!!!");
                    }
                });
            }
            else {
                button.setOnAction(event -> {
                    if(button.isSelected())
                    {
                        System.out.println("\nWrong answer!!!Better luck next time.");
                    }
                });
            }
        }


        /*
        e.setOnAction(event -> {
        if(e.isSelected())
        {
            System.out.println("\nCorrect Answer!!!");
        }
        });
        a.setOnAction(event -> {
            if(a.isSelected())
                System.out.println("\nWrong answer!!!Better luck net time.");
        });
        b.setOnAction(event -> {
            if(b.isSelected())
                System.out.println("\nWrong answer!!!Better luck net time.");
        });
        c.setOnAction(event -> {
            if(c.isSelected())
                System.out.println("\nWrong answer!!!Better luck net time.");
        });
        d.setOnAction(event -> {
            if(d.isSelected())
                System.out.println("\nWrong answer!!!Better luck net time.");
        });

        */
        Button submit =new Button("Submit");
        submit.getStyleClass().add("buttonBlue");
        GridPane.setConstraints(submit, 50, 25);



        //Add buttons

        radios.getChildren().addAll(a,b,c,d,e);
        grid.getChildren().addAll(nameLabel, passInput, radios, question,submit, yesButton, noButton);
        Scene scene = new Scene(grid, 1350, 700);
        scene.getStylesheets().add("viper.css");
        window.setScene(scene);
        window.show();

        //Make sure to return answer
        return answer;
    }

}
