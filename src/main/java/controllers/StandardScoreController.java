/*
 * This controller class controls the inputs and outputs of the z-score page
 * */

package controllers;

import functions.StatisticsStandardScore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.TextAreaConverter;
import main.TextClearField;

import java.util.ArrayList;
import java.util.List;

public class StandardScoreController {
    @FXML private TextArea textAreaData;
    @FXML private TextField textFieldXInput1;
    @FXML private TextField textFieldXInput2;
    @FXML private TextField textFieldPopMeanGiven;
    @FXML private TextField textFieldPopMeanInput;
    @FXML private TextField textFieldStnDevGiven;
    @FXML private TextField textFieldStnDevInput;
    @FXML private TextField textFieldZScore1;
    @FXML private TextField textFieldZScore2;

    List<TextField> zScoreFields = new ArrayList<>();
    List<TextField> zScoreFields2 = new ArrayList<>();
    List<Double> dataSet;

    // If data set is given
    public void onButtonActionCalculate(ActionEvent event) {
        // Takes a dataSet and 1 textField
        dataSet = TextAreaConverter.getTextAreaData(textAreaData.getText());
        StatisticsStandardScore zScore = new StatisticsStandardScore(dataSet, textFieldXInput1);

        textFieldPopMeanGiven.setText(String.valueOf(zScore.getMean()));
        textFieldStnDevGiven.setText(String.valueOf(zScore.getStnDev()));
        textFieldZScore1.setText(String.valueOf(zScore.getZscoreGiven()));

    }

    // Clears the first section of the z-score page(upper)
    public void onButtonActionClear(ActionEvent event) {
        textFieldXInput1.clear();
        zScoreFields.add(textFieldPopMeanGiven);
        zScoreFields.add(textFieldStnDevGiven);
        zScoreFields.add(textFieldZScore1);

        TextClearField zScoreClear = new TextClearField();
        zScoreClear.clearField(textAreaData , zScoreFields);
    }

    // If data set is not given
    public void onButtonActionCalculateZScore(ActionEvent event) {
        // Takes textFields instead of textAreas
        dataSet = TextAreaConverter.getTextAreaData(textAreaData.getText());
        StatisticsStandardScore zScore = new StatisticsStandardScore(textFieldXInput2, textFieldPopMeanInput, textFieldStnDevInput);

        textFieldXInput2.setText(String.valueOf(zScore.getXValueZ()));
        textFieldPopMeanInput.setText(String.valueOf(zScore.getPopMeanZ()));
        textFieldStnDevInput.setText(String.valueOf(zScore.getStandardDeviationZ()));
        textFieldZScore2.setText(String.valueOf(zScore.getZScore()));
    }

    // Clears all textFields of second section of the z-score page(lower)
    public void onButtonActionClearZScore(ActionEvent event) {
        textFieldXInput2.clear();
        zScoreFields2.add(textFieldPopMeanInput);
        zScoreFields2.add(textFieldStnDevInput);
        zScoreFields2.add(textFieldZScore2);

        TextClearField zScoreClear = new TextClearField();
        zScoreClear.clearField(zScoreFields2);
    }
}
