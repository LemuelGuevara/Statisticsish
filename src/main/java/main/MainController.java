/*
* This controller class is the main controller for the calculator
* It contains the stage switching and the main gui
* */

package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Statistics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {
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

    @FXML private VBox contentArea;

    List<Double> data;
    List<TextField> textFieldsList = new ArrayList<>();

    // Calculates the statistics functions
    public void onButtonActionCalculate(ActionEvent event) {
        // Takes a dataSet
        data = TextAreaConverter.getTextAreaData(textAreaData.getText());

        Statistics genCalc = new Statistics(data);
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

        TextClearField clear = new TextClearField(textAreaData, textFieldsList);
        clear.clearField();
    }

    /*
    * Page switching
    * */

    // Switches to general page
    public void switchGeneral(ActionEvent e) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/General.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    // Switches to quartiles page
    public void switchQuartiles(ActionEvent e) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/QuartilePerctentile.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    // Switches to the z-score page
    public void switchZScore(ActionEvent e) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/ZScore.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    // Switches to the outliers page
    public void switchOutliers(ActionEvent e) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Outliers.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    // Switches to the correlation page
    public void switchCorrelation(ActionEvent e) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Correlation.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
}