package controllers;

import functions.StatisticsNormalDistribution;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.TextAreaConverter;
import main.TextClearField;

import java.util.ArrayList;
import java.util.List;

public class NormalDistributionController {
    @FXML private TextArea textAreaData;
    @FXML private TextField textFieldNormalDist1;
    @FXML private TextField textFieldNormalDist2;
    @FXML private TextField textFieldPopMeanGiven;
    @FXML private TextField textFieldPopMeanInput;
    @FXML private TextField textFieldStnDevGiven;
    @FXML private TextField textFieldStnDevInput;
    @FXML private TextField textFieldXInput1;
    @FXML private TextField textFieldXInput2;

    List<TextField> normalDistFields1 = new ArrayList<>();
    List<TextField> normalDistFields2 = new ArrayList<>();
    List<Double> dataSet;

    // If data set is given
    public void onButtonActionCalculate(ActionEvent event) {
        // Takes a dataSet and 1 textField
        dataSet = TextAreaConverter.getTextAreaData(textAreaData.getText());
        StatisticsNormalDistribution normalDist = new StatisticsNormalDistribution(dataSet, textFieldXInput1);

        textFieldPopMeanGiven.setText(String.valueOf(normalDist.getMean()));
        textFieldStnDevGiven.setText(String.valueOf(normalDist.getStnDev()));
        textFieldNormalDist1.setText(String.valueOf(normalDist.getNormalDist()));
    }

    // Clears the first section of the z-score page(upper)
    public void onButtonActionClear(ActionEvent event) {
        textFieldXInput1.clear();
        normalDistFields1.add(textFieldPopMeanGiven);
        normalDistFields1.add(textFieldStnDevGiven);
        normalDistFields1.add(textFieldNormalDist1);

        TextClearField clearField = new TextClearField();
        clearField.clearField(textAreaData, normalDistFields1);
    }

    // If data set is not given
    public void onButtonActionCalculateNormalDist(ActionEvent event) {
        // Takes textFields instead of textAreas
        StatisticsNormalDistribution normalDist = new StatisticsNormalDistribution(textFieldXInput2, textFieldPopMeanInput, textFieldStnDevInput);

        textFieldPopMeanInput.setText(String.valueOf(normalDist.getPopMeanZ()));
        textFieldStnDevInput.setText(String.valueOf(normalDist.getStandardDeviationZ()));
        textFieldNormalDist2.setText(String.valueOf(normalDist.getNormalDist()));
    }

    // Clears all textFields of second section of the z-score page(lower)
    public void onButtonActionClearZScore(ActionEvent event) {
        textFieldXInput2.clear();
        normalDistFields2.add(textFieldPopMeanInput);
        normalDistFields2.add(textFieldStnDevInput);
        normalDistFields2.add(textFieldNormalDist2);

        TextClearField clearField = new TextClearField();
        clearField.clearField(normalDistFields2);
    }
}
