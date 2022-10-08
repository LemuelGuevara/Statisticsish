/*
 * This controller class controls the inputs and outputs of the linear regression page
 * */

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.TextAreaConverter;
import main.TextClearField;
import model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class LinearRegressionController {
    @FXML private TextArea textAreaData1;
    @FXML private TextArea textAreaData2;
    @FXML private TextField textFieldXValue;
    @FXML private TextField textFieldLinearRegress;
    @FXML private ScatterChart<?, ?> ScatterPlot;

    List<Double> data1, data2;
    List<TextField> linearRegressFields = new ArrayList<>();

    // Linear regression
    public void onButtonActionCalculateLinearRegress(ActionEvent event) {
        // Takes 2 dataSets
        data1 = TextAreaConverter.getTextAreaData(textAreaData1.getText());
        data2 = TextAreaConverter.getTextAreaData(textAreaData2.getText());

        Statistics analysis = new Statistics(data1, data2, textFieldXValue);
        Statistics.CorrelationRegression regression = analysis.new CorrelationRegression();
        textFieldLinearRegress.setText(String.valueOf(regression.getLinearRegres()));
    }

    // Clears fields of linear regression page
    public void onButtonActionClearLinearRegress(ActionEvent e) {
        linearRegressFields.add(textFieldXValue);
        linearRegressFields.add(textFieldLinearRegress);

        // Clears textArea and all textFields
        TextClearField clear = new TextClearField(textAreaData1, textAreaData2, linearRegressFields);
        clear.clearField2();
    }
}
