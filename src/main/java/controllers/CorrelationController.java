/*
 * This controller class controls the inputs and outputs of the correlation page
 * */

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.TextAreaConverter;
import main.TextClearField;
import model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class CorrelationController {
    @FXML private TextArea textAreaData1;
    @FXML private TextArea textAreaData2;
    @FXML private TextField textFieldCorrelation;

    List<Double> data1, data2;
    List<TextField> correlationFields = new ArrayList<>();

    // Outliers
    public void onButtonActionCalculateCorrelation(ActionEvent event) {
        // Takes 2 dataSets
        data1 = TextAreaConverter.getTextAreaData(textAreaData1.getText());
        data2 = TextAreaConverter.getTextAreaData(textAreaData2.getText());

        Statistics correlation = new Statistics(data1, data2);
        textFieldCorrelation.setText(String.valueOf(correlation.getCorrel()));

    }
    public void onButtonActionClearCorrelation(ActionEvent e) {
        correlationFields.add(textFieldCorrelation);

        // Clears textArea and all textFields
        TextClearField clear = new TextClearField(textAreaData1, textAreaData2, correlationFields);
        clear.clearField2();
    }
}
