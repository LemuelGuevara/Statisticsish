/*
 * This controller class controls the inputs and outputs of the z-score page
 * */

package controllers.statistics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static controllers.text.TextFieldSetter.*;
import static controllers.text.TextAreaGetter.*;
import controllers.text.TextClearField;
import model.statistics.StatisticsStandardScore;

import static model.statistics.StatisticsArithmetic.*;
import static model.statistics.StatisticsStandardScore.*;

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
        dataSet = getTextAreaData(textAreaData.getText());
        new StatisticsStandardScore(dataSet, textFieldXInput1);

        setTextField(textFieldPopMeanGiven, getMean(dataSet));
        setTextField(textFieldStnDevGiven, getStnDev(dataSet));
        setTextField(textFieldZScore1, standardScore);
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
        StatisticsStandardScore zScore = new StatisticsStandardScore(textFieldXInput2, textFieldPopMeanInput, textFieldStnDevInput);

        setTextField(textFieldZScore2, zScore.getStandardScore());
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
