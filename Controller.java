package calculator.panda.org;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private TextField textField;

    @FXML
    private Text savedNumbers;

    private String firstNumber = "";
    private String currentNumber = "";
    private String calculationType;


    @FXML
    void addAction(ActionEvent event) {
        calculationSetup("+");
    }

    @FXML
    void minusAction(ActionEvent event) {
        calculationSetup("-");
    }

    @FXML
    void divideAction(ActionEvent event) {
        calculationSetup("÷");
    }

    @FXML
    void multiplicationAction(ActionEvent event) {
        calculationSetup("x");
    }

    public void calculationSetup(String calculationType) {
        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
    }

    @FXML
    void calculate(ActionEvent event) {
        double firstNumberInt = Double.parseDouble(firstNumber);
        double secondNumberInt = Double.parseDouble(currentNumber);

        switch(calculationType) {
            case "+" -> {
                double calculatedNumber = firstNumberInt + secondNumberInt;
                savedNumbers.setText(firstNumber + " + "  + currentNumber + " = " + calculatedNumber);
                currentNumber = String.valueOf(calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
            }
            case "-" -> {
                double calculatedNumber = firstNumberInt - secondNumberInt;
                savedNumbers.setText(firstNumber + " - " + currentNumber + " = " + calculatedNumber);
                currentNumber = String.valueOf(calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
            }
            case "÷" -> {
                double calculatedNumber = firstNumberInt / secondNumberInt;
                savedNumbers.setText(firstNumber + " ÷ " + currentNumber + " = " + calculatedNumber);
                currentNumber = String.valueOf(calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
            }
            case "x" -> {
                double calculatedNumber = firstNumberInt * secondNumberInt;
                savedNumbers.setText(firstNumber + " x " + currentNumber + " = " + calculatedNumber);
                currentNumber = String.valueOf(calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
            }
        }
    }

    @FXML
    void clearTextField(ActionEvent event) {
        currentNumber = "";
        textField.setText("");
        savedNumbers.setText("");
    }

    @FXML
    void button0Clicked(ActionEvent event) { addNumber("0"); }

    @FXML
    void button1Clicked(ActionEvent event) { addNumber("1"); }

    @FXML
    void button2Clicked(ActionEvent event) { addNumber("2"); }

    @FXML
    void button3Clicked(ActionEvent event) { addNumber("3"); }

    @FXML
    void button4Clicked(ActionEvent event) { addNumber("4"); }

    @FXML
    void button5Clicked(ActionEvent event) { addNumber("5"); }

    @FXML
    void button6Clicked(ActionEvent event) { addNumber("6"); }

    @FXML
    void button7Clicked(ActionEvent event) { addNumber("7"); }

    @FXML
    void button8Clicked(ActionEvent event) { addNumber("8"); }

    @FXML
    void button9Clicked(ActionEvent event) { addNumber("9"); }

    public void updateTextField() { textField.setText(currentNumber); }

    public void addNumber(String number) {
        currentNumber += number;
        updateTextField();
    }
}
