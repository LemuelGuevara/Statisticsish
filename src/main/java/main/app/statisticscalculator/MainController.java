/*
* This controller class is the main controller for the calculator
* */

package main.app.statisticscalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    @FXML
    private TextArea textAreaData;
    @FXML
    private TextField textFieldCount;
    @FXML
    private TextField textFieldSum;
    @FXML
    private TextField textFieldMean;
    @FXML
    private TextField textFieldMedian;
    @FXML
    private TextField textFieldMode;
    @FXML
    private TextField textFieldMax;
    @FXML
    private TextField textFieldMin;
    @FXML
    private TextField textFieldRange;
    @FXML
    private TextField textFieldVariance;
    @FXML
    private TextField textFieldStnDev;

    List<Double> data;

    // Calculates the statistics functions
    public void calculate(ActionEvent event) {
        // Gets textAreaInput then converts into a list
        String textAreaInput = textAreaData.getText();
        data = TextAreaConverter.getTextAreaData(textAreaInput); // List converter

        // Creates a new constructor (statistics) then passes in the dataSet and the dataSet count
        Statistics genCalc = new Statistics(data);
        // Statistics computation results
        textFieldCount.setText(genCalc.getCount());
        textFieldSum.setText(genCalc.getSum());
        textFieldMean.setText(genCalc.getMean());
        textFieldMedian.setText(genCalc.getMedian());
        textFieldMode.setText(genCalc.getMode());
        textFieldMax.setText(genCalc.getMax());
        textFieldMin.setText(genCalc.getMin());
        textFieldRange.setText(genCalc.getRange());
        textFieldVariance.setText(genCalc.getVar());
        textFieldStnDev.setText(genCalc.getStnDev());
    }

    public void clear(ActionEvent e) {
        textAreaData.setText("");
        textFieldCount.setText("");
        textFieldSum.setText("");
        textFieldMean.setText("");
        textFieldMedian.setText("");
        textFieldMode.setText("");
        textFieldMax.setText("");
        textFieldMin.setText("");
        textFieldRange.setText("");
        textFieldVariance.setText("");
    }
}