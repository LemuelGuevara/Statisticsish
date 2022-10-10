/*
 * This controller class controls the inputs and outputs of the correlation page
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

public class CorrelationController {
    @FXML private TextArea textAreaData1;
    @FXML private TextArea textAreaData2;
    @FXML private TextField textFieldCorrelation;

    List<Double> data1, data2;
    List<TextField> correlationFields = new ArrayList<>();

    // Correlation
    public void onButtonActionCalculateCorrelation(ActionEvent event) {
        // Takes 2 dataSets
        data1 = getTextAreaData(textAreaData1.getText());
        data2 = getTextAreaData(textAreaData2.getText());

        StatisticsRegression correlation = new StatisticsRegression(data1, data2);
        setTextField(textFieldCorrelation, correlation.getCorrelation());
    }

    // Clears all fields of correlation
    public void onButtonActionClearCorrelation(ActionEvent e) {
        correlationFields.add(textFieldCorrelation);

        // Clears textArea and all textFields
        TextClearField clear = new TextClearField();
        clear.clearField(textAreaData1, textAreaData2, correlationFields);
    }
}
