/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author CodyB
 */
public class FXMLDocumentController implements Initializable {
    private String firstOperand = "0";
        private boolean operandValid(String operand) {
            if (operand.contains("0") ||
                operand.contains("1") ||
                operand.contains("2") ||
                operand.contains("3") ||
                operand.contains("4") ||
                operand.contains("5") ||
                operand.contains("6") ||
                operand.contains("7") ||
                operand.contains("8") ||
                operand.contains("9"))
                
                return true;
            return false;
        }
        private boolean resultDisplayed = false;        

    @FXML
    private TextField displayTextField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // The following will force the field to be numeric only.
        // Limits imposed are an optional minus sign, up to 7 signifigant
        // digits, an optional decimal point followed by up to 4 digits
        displayTextField.textProperty().addListener(
         (ObservableValue<? extends String> observable, String oldValue,
                String newValue) -> {
        if (!newValue.matches("(\\-{0,1})\\d{0,7}([\\.]\\d{0,4})?")) {
            displayTextField.setText(oldValue);
        }
     });    
     
    }    

    @FXML
    private void seven(ActionEvent event) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "7");
    }

    @FXML
    private void eight(ActionEvent event) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "8");
    }

    @FXML
    private void nine(ActionEvent event) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "9");
    }
    

    @FXML
    private void multiply(ActionEvent event) {
        double first = Double.parseDouble(firstOperand);
        String secondOperand = displayTextField.getText();
        double second = 0;
    
    if (operandValid(secondOperand)) {
        second = Double.parseDouble(secondOperand);
    }
    double result = first * second;
    firstOperand = "" + result;
    displayTextField.setText(firstOperand);
    resultDisplayed = true;
    }

    @FXML
    private void four(ActionEvent event) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "4");
    }

    @FXML
    private void five(ActionEvent event) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "5");
    }

    @FXML
    private void six(ActionEvent event) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "6");
    }

    @FXML
    private void divide(ActionEvent event) {
        double first = Double.parseDouble(firstOperand);
        String secondOperand = displayTextField.getText();
        double second = 0;
    
    if (operandValid(secondOperand)) {
        second = Double.parseDouble(secondOperand);
    }
    double result = first / second;
    firstOperand = "" + result;
    displayTextField.setText(firstOperand);
    resultDisplayed = true;
    }

    @FXML
    private void one(ActionEvent event) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "1");
    }

    @FXML
    private void two(ActionEvent event) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "2");
    }

    @FXML
    private void three(ActionEvent event) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "3");
    }

    @FXML
    private void subtract(ActionEvent event) {
        double first = Double.parseDouble(firstOperand);
        String secondOperand = displayTextField.getText();
        double second = 0;
    
    if (operandValid(secondOperand)) {
        second = Double.parseDouble(secondOperand);
    }
    double result = first - second;
    firstOperand = "" + result;
    displayTextField.setText(firstOperand);
    resultDisplayed = true;
    }

    @FXML
    private void zero(ActionEvent event) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "0");
    }

    @FXML
    private void point(ActionEvent event) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + ".");
    }

    @FXML
    private void enter(ActionEvent event) {
        firstOperand = displayTextField.getText();
        displayTextField.setText("");        
    }

    @FXML
    private void add(ActionEvent event) {
        double first = Double.parseDouble(firstOperand);
        String secondOperand = displayTextField.getText();
        double second = 0;
    
    if (operandValid(secondOperand)) {
        second = Double.parseDouble(secondOperand);
    }
    double result = first + second;
    firstOperand = "" + result;
    displayTextField.setText(firstOperand);
    resultDisplayed = true;
    }

    @FXML
    private void changeSign(ActionEvent event) {
        String display = displayTextField.getText();
        if (display.startsWith("-"))
            display = display.substring(1);
        else
            display = "-" + display;
        displayTextField.setText(display);  
    }
    
    private void eraseDisplay() {
        if (resultDisplayed) {
            displayTextField.setText("");
            resultDisplayed = false;
            }
    }    
}
