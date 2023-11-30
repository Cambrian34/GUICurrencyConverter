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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class Main extends Application {
    private static final String API_KEY = "33a6de0373ba46d3980403bfb1f4915a"; // Replace with your actual API key

    public HBox addHBox() {
        HBox hbox = new HBox();
        Text text = new Text();
        text.setText("Currency Converter");
        text.setX(200);
        text.setY(10);
        hbox.getChildren().add(text);
        return hbox;
    }


    float outputt;

    @Override
    public void start(Stage primaryStage) {

        HBox box = addHBox();
        HBox boxLeft = new HBox();
        TextField input = new TextField();
        boxLeft.getChildren().add(input);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("USD", "EUR", "JPY","JMD"); // Using ISO currency codes
        HBox boxCenter = new HBox();
        boxCenter.getChildren().add(choiceBox);

        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        HBox boxRight = new HBox();
        choiceBox1.getItems().addAll("USD", "EUR", "JPY","JMD");
        boxRight.getChildren().add(choiceBox1);

        HBox boxBottom = new HBox();
        TextField output = new TextField();
        Button apply = new Button("Convert");
        boxBottom.getChildren().addAll(output, apply);

        apply.setOnAction(event -> {
            String fromCurrency = choiceBox.getValue();
            String toCurrency = choiceBox1.getValue();
            float amount = Float.parseFloat(input.getText());

            float conversionRate = getExchangeRate(fromCurrency, toCurrency);

            outputt = amount * conversionRate;
            output.setText(String.valueOf(outputt));
        });

        BorderPane pane = new BorderPane();
        pane.setTop(box);
        pane.setLeft(boxLeft);
        pane.setCenter(boxCenter);
        pane.setRight(boxRight);
        pane.setBottom(boxBottom);

        Group root = new Group(pane);
        Scene scene = new Scene(root, 600, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Currency Converter");
        primaryStage.show();
    }

    private float getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            URL url = new URL("https://open.er-api.com/v6/latest/" + fromCurrency + "?apikey=" + API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //print the status code to console
            System.out.println(connection.getResponseCode());

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            // Parse the JSON response to get the exchange rate
            // This is a simplified example; you may want to use a JSON library for better handling
            // Parse the JSON response using org.json library
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject rates = jsonResponse.getJSONObject("rates");
            float exchangeRate = (float) rates.getDouble(toCurrency);

            return exchangeRate;
        } catch (IOException e) {
            e.printStackTrace();
            return 1.0f; // Default to 1:1 conversion if there's an error
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
