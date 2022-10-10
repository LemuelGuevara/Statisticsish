package controllers.statistics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static controllers.text.TextFieldSetter.*;
import static controllers.text.TextAreaConverter.*;
import controllers.text.TextClearField;

import static model.statistics.StatisticsArithmetic.*;
import model.statistics.StatisticsNormalDistribution;
import static model.statistics.StatisticsNormalDistribution.*;

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
        dataSet = getTextAreaData(textAreaData.getText());
        new StatisticsNormalDistribution(dataSet, textFieldXInput1);

        setTextField(textFieldPopMeanGiven, getMean(dataSet));
        setTextField(textFieldStnDevGiven, getStnDev(dataSet));
        setTextField(textFieldNormalDist1, normalDist);
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

        setTextField(textFieldNormalDist2, normalDist.getNormalDist());
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
