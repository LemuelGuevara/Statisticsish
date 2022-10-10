/*
 * This controller class is the general controller for the calculator
 * It contains the stage switching and the general page
 * */

package controllers.statistics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static controllers.text.TextFieldSetter.*;
import static controllers.text.TextAreaGetter.*;
import controllers.text.TextClearField;
import model.statistics.StatisticsArithmetic;

import static model.statistics.StatisticsArithmetic.*;

import java.util.ArrayList;
import java.util.List;

public class GeneralController {
    @FXML private TextArea textAreaData;
    @FXML private TextField textFieldCount;
    @FXML private TextField textFieldSum;
    @FXML private TextField textFieldMean;
    @FXML private TextField textFieldMedian;
    @FXML private TextField textFieldMode;
    @FXML private TextField textFieldMax;
    @FXML private TextField textFieldMin;
    @FXML private TextField textFieldRange;
    @FXML private TextField textFieldVariance;
    @FXML private TextField textFieldStnDev;

    List<Double> data;
    List<TextField> textFieldsList = new ArrayList<>();

    // Calculates the statistics functions
    public void onButtonActionCalculate(ActionEvent event) {
        // Takes a dataSet
        data = getTextAreaData(textAreaData.getText());

        StatisticsArithmetic stats =  new StatisticsArithmetic(data);

        setTextField(textFieldCount, getCount());
        setTextField(textFieldSum, getSum());
        setTextField(textFieldMean, getMean());
        setTextField(textFieldMedian, getMedian());
        setTextField(textFieldMode, getMode());
        setTextField(textFieldMax, getMax());
        setTextField(textFieldMin, getMin());
        setTextField(textFieldRange, getRange());
        setTextField(textFieldVariance, getVar());
        setTextField(textFieldStnDev, getStnDev());
    }

    // Clears all textFields and textArea
    public void onButtonActionClear(ActionEvent e) {
        textFieldsList.add(textFieldCount);
        textFieldsList.add(textFieldSum);
        textFieldsList.add(textFieldMean);
        textFieldsList.add(textFieldMedian);
        textFieldsList.add(textFieldMode);
        textFieldsList.add(textFieldMax);
        textFieldsList.add(textFieldMin);
        textFieldsList.add(textFieldRange);
        textFieldsList.add(textFieldVariance);
        textFieldsList.add(textFieldStnDev);

        TextClearField clear = new TextClearField();
        clear.clearField(textAreaData, textFieldsList);
    }
}