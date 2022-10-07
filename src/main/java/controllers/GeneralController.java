package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import main.MainController;
import main.TextAreaConverter;
import main.TextClearField;
import model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class GeneralController {
    @FXML
    private TextArea textAreaData;
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
    @FXML private VBox contentArea;

    List<Double> data;
    List<TextField> textFieldsList = new ArrayList<>();

    // Calculates the statistics functions
    public void onButtonActionCalculate(ActionEvent event) {
        // Gets textAreaInput then converts into a list
        data = TextAreaConverter.getTextAreaData(textAreaData.getText()); // List converter

        // Creates a new constructor (statistics) then passes in the dataSet and the dataSet count
        Statistics genCalc = new Statistics(data);
        // Statistics computation results
        textFieldCount.setText(String.valueOf(genCalc.count));
        textFieldSum.setText(String.valueOf(genCalc.getSum()));
        textFieldMean.setText(String.valueOf(genCalc.getMean()));
        textFieldMedian.setText(String.valueOf(genCalc.getMedian()));
        textFieldMode.setText(String.valueOf(genCalc.getMode()));
        textFieldMax.setText(String.valueOf(genCalc.getMax()));
        textFieldMin.setText(String.valueOf(genCalc.getMin()));
        textFieldRange.setText(String.valueOf(genCalc.getRange()));
        textFieldVariance.setText(String.valueOf(genCalc.getVar()));
        textFieldStnDev.setText(String.valueOf(genCalc.getStnDev()));
        genCalc.execTime();
    }
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

        // Clears textArea and all textFields
        TextClearField clear = new TextClearField(textAreaData, textFieldsList);
        clear.clearField();
    }
}
