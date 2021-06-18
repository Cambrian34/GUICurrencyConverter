import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public HBox addhbox(){
        HBox hbox = new HBox();
        Text text = new Text();
        text.setText("Currency Converter");
        text.setX(200);
        text.setY(10);

        hbox.getChildren().add(text);

        return hbox;
    }
    int selectedIndex;
    int selectedIndex1;
    float outputt;
    @Override

    public void start(Stage primaryStage) {

        HBox box = addhbox();
        //input.setAlignment(Pos.BASELINE_CENTER);
        HBox boxLeft = new HBox();
        TextField input = new TextField();
        boxLeft.getChildren().add(input);
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("JMD","US","JPN");
        HBox boxCenter = new HBox();
        boxCenter.getChildren().add(choiceBox);
        ChoiceBox choiceBox1 = new ChoiceBox();
        HBox boxRight = new HBox();
        choiceBox1.getItems().addAll("JMD","US","JPN");
        boxRight.getChildren().add(choiceBox1);
        HBox boxBottom = new HBox();
        TextField output = new TextField();
        Button apply = new Button("Convert");
        boxBottom.getChildren().addAll(output,apply);

        choiceBox.setOnAction((event -> {
            selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = choiceBox.getSelectionModel().getSelectedItem();

            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
            System.out.println("   ChoiceBox.getValue(): " + choiceBox.getValue());


        }));
        choiceBox1.setOnAction((event -> {
            selectedIndex1 = choiceBox1.getSelectionModel().getSelectedIndex();
            Object selectedItem1 = choiceBox1.getSelectionModel().getSelectedItem();

            System.out.println("Selection made: [" + selectedIndex1 + "] " + selectedItem1);
            System.out.println("   ChoiceBox.getValue(): " + choiceBox1.getValue());
        }));

        apply.setOnAction(event -> {
           String  in = (input.getText());
           float intin = (Integer.parseInt(in));

            if(selectedIndex == 0 && selectedIndex1 ==0){
                outputt =intin*1;
            }
            if(selectedIndex == 1 && selectedIndex1 == 0){

                outputt = (float) (intin*150.42);
            }
            if(selectedIndex == 2 && selectedIndex1 == 0){

                outputt = (float) (intin*1.36);
            }
            if(selectedIndex == 0 && selectedIndex1 ==1){
                outputt = (float) (intin*150.42);
            }
            if(selectedIndex == 1 && selectedIndex1 ==1){

                outputt = intin*1;
            }
            if(selectedIndex == 2 && selectedIndex1 == 1){

                outputt = (float) (intin*110.23);
            }
            if(selectedIndex == 0 && selectedIndex1 == 2){
                outputt = (float) (intin*0.73);
            }
            if(selectedIndex == 1 && selectedIndex1 ==2){

                outputt = (float) (intin*110.23);
            }
            if(selectedIndex == 2 && selectedIndex1 ==2){
                outputt = intin*1;

            }

            output.setText(String.valueOf(outputt));

        });


        BorderPane pane = new BorderPane();
        pane.setTop(box);
        pane.setLeft(boxLeft);
        pane.setCenter(boxCenter);
        pane.setRight(boxRight);
        pane.setBottom(boxBottom);

        Group root = new Group(pane);
        Scene scene = new Scene(root,600,200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Currency Converter");
        primaryStage.show();

    }
    /*public static void Main(String[] args){
        launch(args);
    }*/
}
