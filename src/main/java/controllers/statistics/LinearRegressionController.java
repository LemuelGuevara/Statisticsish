/*
 * This controller class controls the inputs and outputs of the linear regression page
 * */

package controllers.statistics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static controllers.text.TextFieldSetter.*;
import static controllers.text.TextAreaConverter.*;
import controllers.text.TextClearField;

import model.statistics.StatisticsRegression;

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
        data1 = getTextAreaData(textAreaData1.getText());
        data2 = getTextAreaData(textAreaData2.getText());

        StatisticsRegression linear = new StatisticsRegression(data1, data2, textFieldXValue);
        setTextField(textFieldLinearRegress, linear.getLinearRegression());
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
