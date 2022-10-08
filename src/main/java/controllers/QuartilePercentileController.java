/*
 * This controller class controls the inputs and outputs of the quartiles page
 * */

package controllers;

import functions.StatisticsQuartilePercentile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.TextAreaConverter;
import main.TextClearField;
import functions.Statistics;

import java.util.ArrayList;
import java.util.List;

public class QuartilePercentileController {
    @FXML private TextArea textAreaData;
    @FXML private TextField textFieldQuart1;
    @FXML private TextField textFieldQuart2;
    @FXML private TextField textFieldQuart3;
    @FXML private TextField textFieldPercentileValue;
    @FXML private TextField textFieldPercentileInput;

    List<TextField> quartFields = new ArrayList<>();
    List<Double> dataSet;

    // Quartile
    public void onButtonActionCalculateQuart(ActionEvent event) {
        // Takes a dataSet
        dataSet = TextAreaConverter.getTextAreaData(textAreaData.getText());
        StatisticsQuartilePercentile quartiles = new StatisticsQuartilePercentile(dataSet);

        textFieldQuart1.setText(String.valueOf(quartiles.getQuart1()));
        textFieldQuart2.setText(String.valueOf(quartiles.getQuart2()));
        textFieldQuart3.setText(String.valueOf(quartiles.getQuart3()));
    }

    // Clears all textFields of the quartiles
    public void onButtonActionClearQuart(ActionEvent e) {
        quartFields.add(textFieldQuart1);
        quartFields.add(textFieldQuart2);
        quartFields.add(textFieldQuart3);

        TextClearField quartsClear = new TextClearField(textAreaData , quartFields);
        quartsClear.clearField();
    }

    // Percentile
    public void onButtonActionCalculatePerct() {
        // Takes a textField
        dataSet = TextAreaConverter.getTextAreaData(textAreaData.getText());
        StatisticsQuartilePercentile percentile = new StatisticsQuartilePercentile(dataSet, textFieldPercentileInput);

        textFieldPercentileValue.setText(String.valueOf(percentile.getPercentile()));
    }

    // Clears all the textFields of the percentiles
    public void onButtonActionClearPerct(ActionEvent e) {
        textFieldPercentileInput.clear();
        textFieldPercentileValue.clear();
    }
}
