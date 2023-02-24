import com.sun.javafx.collections.IntegerArraySyncer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ChangeMakerGUI extends Application
{
    private TextField tfAmountOwed = new TextField();
    private TextField tfAmountPaid = new TextField();
    private TextField tfCoinDenominations =  new TextField();
    private TextField tfChangeOwedBack = new TextField();
    private TextField tfCoinsNeeded = new TextField();
    private Button btCalculate = new Button("Calculate");


    @Override
    public void start(Stage primaryStage) {

    GridPane gridPane =new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Amount Owed:"),0,0);
    gridPane.add(tfAmountOwed,1,0);
    gridPane.add(new Label("Amount Paid:"),0,1);
    gridPane.add(tfAmountPaid,1,1);
    gridPane.add(new Label("Coin denominations:"),0,2);
    gridPane.add(tfCoinDenominations,1,2);
    gridPane.add(new Label("Change Owed Back:"), 0,3);
    gridPane.add(tfChangeOwedBack,1,3);
    gridPane.add(new Label("Coins Needed:"),0,4);
    gridPane.add(tfCoinsNeeded,1,4);
    gridPane.add(btCalculate,1,5);

    gridPane.setAlignment(Pos.CENTER);
    tfAmountOwed.setAlignment(Pos.BOTTOM_RIGHT);
    tfAmountPaid.setAlignment(Pos.BOTTOM_RIGHT);
    tfCoinDenominations.setAlignment(Pos.BOTTOM_RIGHT);
    tfChangeOwedBack.setAlignment(Pos.BOTTOM_RIGHT);
    tfCoinsNeeded.setAlignment(Pos.BOTTOM_RIGHT);
    tfChangeOwedBack.setEditable(false);
    tfCoinsNeeded.setEditable(false);
    GridPane.setHalignment(btCalculate,HPos.RIGHT);

    btCalculate.setOnAction(e ->calculateChangeMaker());

    Scene scene = new Scene(gridPane,400,250);
    primaryStage.setTitle("ChangeMaker");
    primaryStage.setScene(scene);
    primaryStage.show();
    }

    private void calculateChangeMaker()
    {
        double owed = Double.parseDouble(tfAmountOwed.getText());
        double paid = Double.parseDouble(tfAmountPaid.getText());

        String denominations = tfCoinDenominations.getText();
        String[] denArrayString = denominations.split(",");
        int [] denArrayInt = new int[denArrayString.length];



        for (int i=0; i< denArrayString.length;i++)
        {
           denArrayInt[i] =  Integer.parseInt(denArrayString[i]);

        }



        for (int i=0; i<3; i++)
        {
            System.out.println(denArrayInt[i]);
        }

        int amount = (int) (Math.ceil((paid-owed)*100));
        double doubleAmount=amount;
        double finalAmount=doubleAmount/100;
        System.out.println(finalAmount);

        int [] coins = denArrayInt;



//        ChangeMaker changeMaker = new ChangeMaker();
        int[] solution = ChangeMaker.subproblem(amount,denArrayInt);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3;i++)
        {
            System.out.println(solution[i]);
            sb.append(solution[i]);
        }


        System.out.println(sb.toString());

        tfChangeOwedBack.setText(String.format("$%.2f",finalAmount ));
        tfCoinsNeeded.setText(sb.toString());


    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
