/*
 * This controller class controls the inputs and outputs of the linear regression page
 * */

package controllers;

import functions.StatisticsRegression;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.TextAreaConverter;
import main.TextClearField;

import java.util.ArrayList;
import java.util.List;

public class LinearRegressionController {
    @FXML private TextArea textAreaData1;
    @FXML private TextArea textAreaData2;
    @FXML private TextField textFieldXValue;
    @FXML private TextField textFieldLinearRegress;

    List<Double> data1, data2;
    List<TextField> linearRegressFields = new ArrayList<>();

    // Linear regression
    public void onButtonActionCalculateLinearRegress(ActionEvent event) {
        // Takes 2 dataSets
        data1 = TextAreaConverter.getTextAreaData(textAreaData1.getText());
        data2 = TextAreaConverter.getTextAreaData(textAreaData2.getText());

        StatisticsRegression linear = new StatisticsRegression(data1, data2, textFieldXValue);
        textFieldLinearRegress.setText(String.valueOf(linear.getLinearRegression()));
    }

    // Clears fields of linear regression page
    public void onButtonActionClearLinearRegress(ActionEvent e) {
        linearRegressFields.add(textFieldXValue);
        linearRegressFields.add(textFieldLinearRegress);

        // Clears textArea and all textFields
        TextClearField clear = new TextClearField();
        clear.clearField(textAreaData1, textAreaData2, linearRegressFields);
    }
}
