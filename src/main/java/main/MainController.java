/*
* This controller class is the main controller for the calculator
* It contains the stage switching and the main gui
* */

package main;

import controllers.text.TextAreaConverter;
import controllers.text.TextClearField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.statistics.StatisticsArithmetic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static controllers.text.TextFieldSetter.setTextField;

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

        StatisticsArithmetic stats = new StatisticsArithmetic(data);

        setTextField(textFieldCount, StatisticsArithmetic.getCount());
        setTextField(textFieldSum, StatisticsArithmetic.getSum());
        setTextField(textFieldMean, StatisticsArithmetic.getMean());
        setTextField(textFieldMedian, StatisticsArithmetic.getMedian());
        setTextField(textFieldMode, StatisticsArithmetic.getMode());
        setTextField(textFieldMax, StatisticsArithmetic.getMax());
        setTextField(textFieldMin, StatisticsArithmetic.getMin());
        setTextField(textFieldRange, StatisticsArithmetic.getRange());
//        setTextField(textFieldVariance, stats.getVar());
//        setTextField(textFieldStnDev, stats.getStnDev());
        System.out.println(StatisticsArithmetic.getSum());
        System.out.println(stats.getStnDev());
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
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/StandardScoreController.fxml"));
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

    // Switches to the linear regression page
    public void switchLinearRegression(ActionEvent e) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/LinearRegression.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    // Switches to the normal distribution page
    public void switchNormalDistribution(ActionEvent e) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/NormalDistribution.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
}