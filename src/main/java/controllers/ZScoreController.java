/*
 * This controller class controls the inputs and outputs of the z-score page
 * */

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.TextAreaConverter;
import main.TextClearField;
import model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class ZScoreController {
    @FXML private TextArea textAreaData;
    @FXML private TextField textFieldXValue1;
    @FXML private TextField textFieldXValue2;
    @FXML private TextField textFieldPopMeanGiven;
    @FXML private TextField textFieldPopMean;
    @FXML private TextField textFieldStnDevGiven;
    @FXML private TextField textFieldStnDev;
    @FXML private TextField textFieldZScore1;
    @FXML private TextField textFieldZScore2;

    List<TextField> zScoreFields = new ArrayList<>();
    List<TextField> zScoreFields2 = new ArrayList<>();
    List<Double> dataSet;

    // If data set is given
    public void onButtonActionCalculate(ActionEvent event) {
        // Takes a dataSet and 1 textField
        dataSet = TextAreaConverter.getTextAreaData(textAreaData.getText());
        Statistics zScore = new Statistics(dataSet, textFieldXValue1);

        textFieldPopMeanGiven.setText(String.valueOf(zScore.getMean()));
        textFieldStnDevGiven.setText(String.valueOf(zScore.getStnDev()));
        textFieldZScore1.setText(String.valueOf(zScore.getZscoreGiven()));

    }

    // Clears the first section of the z-score page(upper)
    public void onButtonActionClear(ActionEvent event) {
        textFieldXValue1.clear();
        zScoreFields.add(textFieldPopMeanGiven);
        zScoreFields.add(textFieldStnDevGiven);
        zScoreFields.add(textFieldZScore1);

        TextClearField zScoreClear = new TextClearField(textAreaData , zScoreFields);
        zScoreClear.clearField();
    }

    // If data set is not given
    public void onButtonActionCalculateZScore(ActionEvent event) {
        // Takes textFields instead of textAreas
        dataSet = TextAreaConverter.getTextAreaData(textAreaData.getText());
        Statistics zScore = new Statistics(dataSet, textFieldXValue2, textFieldPopMean, textFieldStnDev);
        Statistics.ZScore zScores = zScore.new ZScore();

        textFieldXValue2.setText(String.valueOf(zScores.getXValue()));
        textFieldPopMean.setText(String.valueOf(zScores.getPopMean()));
        textFieldStnDev.setText(String.valueOf(zScores.getStandardDeviation()));
        textFieldZScore2.setText(String.valueOf(zScores.getZScore()));
    }

    // Clears all textFields of second section of the z-score page(lower)
    public void onButtonActionClearZScore(ActionEvent event) {
        textFieldXValue2.clear();
        zScoreFields2.add(textFieldPopMean);
        zScoreFields2.add(textFieldStnDev);
        zScoreFields2.add(textFieldZScore2);

        TextClearField zScoreClear = new TextClearField(textAreaData , zScoreFields2);
        zScoreClear.clearField();
    }
}
