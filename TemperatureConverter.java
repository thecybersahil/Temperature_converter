//This application uses two text fields to allow the user to enter a temperature in either Celsius or Fahrenheit. 
// It also provides two buttons to convert the temperature between the two units. 
// The conversion is performed using simple arithmetic calculations. 
// If the user enters an invalid input (such as a non-numeric value), the application displays an error message 
// in the corresponding text field.



import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TemperatureConverter extends Application {

    private TextField celsiusField;
    private TextField fahrenheitField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Temperature Converter");

        // Create input fields
        celsiusField = new TextField();
        fahrenheitField = new TextField();

        // Create labels
        Label celsiusLabel = new Label("Celsius");
        Label fahrenheitLabel = new Label("Fahrenheit");

        // Create conversion buttons
        Button celsiusToFahrenheitButton = new Button("Convert to Fahrenheit");
        celsiusToFahrenheitButton.setOnAction(event -> convertCelsiusToFahrenheit());
        Button fahrenheitToCelsiusButton = new Button("Convert to Celsius");
        fahrenheitToCelsiusButton.setOnAction(event -> convertFahrenheitToCelsius());

        // Create layout
        HBox celsiusBox = new HBox(celsiusField, celsiusLabel);
        celsiusBox.setSpacing(10);
        celsiusBox.setAlignment(Pos.CENTER);

        HBox fahrenheitBox = new HBox(fahrenheitField, fahrenheitLabel);
        fahrenheitBox.setSpacing(10);
        fahrenheitBox.setAlignment(Pos.CENTER);

        VBox inputBox = new VBox(celsiusBox, fahrenheitBox);
        inputBox.setSpacing(20);
        inputBox.setAlignment(Pos.CENTER);

        HBox buttonBox = new HBox(celsiusToFahrenheitButton, fahrenheitToCelsiusButton);
        buttonBox.setSpacing(20);
        buttonBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(inputBox, buttonBox);
        layout.setSpacing(20);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convertCelsiusToFahrenheit() {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            double fahrenheit = (celsius * 1.8) + 32;
            fahrenheitField.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException e) {
            fahrenheitField.setText("Invalid input");
        }
    }

    private void convertFahrenheitToCelsius() {
        try {
            double fahrenheit = Double.parseDouble(fahrenheitField.getText());
            double celsius = (fahrenheit - 32) / 1.8;
            celsiusField.setText(String.format("%.2f", celsius));
        } catch (NumberFormatException e) {
            celsiusField.setText("Invalid input");
        }
    }
}
