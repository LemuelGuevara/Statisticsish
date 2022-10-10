/*
 * This controller class controls the inputs and outputs of the quartiles page
 * */

package controllers.statistics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static controllers.text.TextFieldSetter.*;
import static controllers.text.TextAreaGetter.*;
import controllers.text.TextClearField;

import model.statistics.StatisticsQuartilePercentile;

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
        dataSet = getTextAreaData(textAreaData.getText());
        StatisticsQuartilePercentile quartiles = new StatisticsQuartilePercentile(dataSet);

        setTextField(textFieldQuart1, quartiles.getQuart1());
        setTextField(textFieldQuart2, quartiles.getQuart2());
        setTextField(textFieldQuart3, quartiles.getQuart3());
    }

    // Clears all textFields of the quartiles
    public void onButtonActionClearQuart(ActionEvent e) {
        quartFields.add(textFieldQuart1);
        quartFields.add(textFieldQuart2);
        quartFields.add(textFieldQuart3);

        TextClearField quartsClear = new TextClearField();
        quartsClear.clearField(textAreaData , quartFields);
    }

    // Percentile
    public void onButtonActionCalculatePerct() {
        // Takes a textField
        dataSet = getTextAreaData(textAreaData.getText());
        StatisticsQuartilePercentile percentile = new StatisticsQuartilePercentile(dataSet, textFieldPercentileInput);

        setTextField(textFieldPercentileValue, percentile.getPercentile());
    }

    // Clears all the textFields of the percentiles
    public void onButtonActionClearPerct(ActionEvent e) {
        textFieldPercentileInput.clear();
        textFieldPercentileValue.clear();
    }
}
