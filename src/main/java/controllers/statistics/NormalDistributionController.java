package controllers.statistics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static controllers.text.TextFieldSetter.*;

import static model.statistics.StatisticsArithmetic.*;
import model.statistics.StatisticsNormalDistribution;

import java.util.ArrayList;
import java.util.List;

public class NormalDistributionController {
    @FXML private TextField textFieldComul1;
    @FXML private TextField textFieldComul2;
    @FXML private TextField textFieldComul3;
    @FXML private TextField textFieldComul4;
    @FXML private TextField textFieldComul5;
    @FXML private TextField textFieldComul6;
    @FXML private TextField textFieldZValue1;
    @FXML private TextField textFieldZValue2;
    @FXML private TextField textFieldZValue3;
    @FXML private TextField textFieldZValue4;
    @FXML private TextField textFieldAreaZValue1;
    @FXML private TextField textFieldAreaXValue1;
    @FXML private TextField textFieldAreaXValue2;
    @FXML private TextField textFieldAreaZValue2;
    @FXML private TextField textFieldXValue1;
    @FXML private TextField textFieldXValue2;
    @FXML private TextField textFieldXValue3;
    @FXML private TextField textFieldXValue4;
    @FXML private TextField textFieldMean1;
    @FXML private TextField textFieldMean2;
    @FXML private TextField textFieldMean3;
    @FXML private TextField textFieldStnDev1;
    @FXML private TextField textFieldStndDev2;
    @FXML private TextField textFieldStnDev3;

    /* Section with z-scores*/

    StatisticsNormalDistribution normalDist = new StatisticsNormalDistribution();

    // Cumulative area
    public void onButtonActionCalculate1(ActionEvent event) {
        setTextField(textFieldComul1, normalDist.getCumulative(textFieldZValue1));
    }

    // Cumulative area compliment
    public void onButtonActionCalculate2(ActionEvent event) {
        setTextField(textFieldComul2, normalDist.getCumulativeCompliment(textFieldZValue2));
    }

    // Area between the curves
    public void onButtonActionCalculate3(ActionEvent event) {
        setTextField(textFieldComul3, normalDist.getAreaBetweenCurves(textFieldZValue3, textFieldZValue4));

        setTextField(textFieldAreaZValue1, roundOff(normalDist.cumul1, 4));
        setTextField(textFieldAreaZValue2, roundOff(normalDist.cumul2, 4));
    }

    /* Section without z-scores */

    public void onButtonActionCalculate4(ActionEvent event) {
        StatisticsNormalDistribution cumulative = new StatisticsNormalDistribution(textFieldXValue1, textFieldMean1, textFieldStnDev1);

        setTextField(textFieldComul4, cumulative.getCumulative());
    }

    // Cumulative area compliment
    public void onButtonActionCalculate5(ActionEvent event) {
        StatisticsNormalDistribution cumulativeCompliment = new StatisticsNormalDistribution(textFieldXValue2, textFieldMean2, textFieldStndDev2);

        setTextField(textFieldComul5, cumulativeCompliment.getCumulativeCompliment());

    }

    // Area between the curves
    public void onButtonActionCalculate6(ActionEvent event) {
        StatisticsNormalDistribution  areaBetweenCurves = new StatisticsNormalDistribution(textFieldXValue3, textFieldXValue4, textFieldMean3, textFieldStnDev3);

        setTextField(textFieldAreaXValue1, roundOff(areaBetweenCurves.cumulativeProbability1, 4));
        setTextField(textFieldAreaXValue2, roundOff(areaBetweenCurves.cumulativeProbability2, 4));

        setTextField(textFieldComul6, areaBetweenCurves.getAreaBetweenCurves());
    }
}
