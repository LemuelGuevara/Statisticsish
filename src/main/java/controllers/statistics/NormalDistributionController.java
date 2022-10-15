package controllers.statistics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static controllers.text.TextFieldSetter.*;

import static model.statistics.StatisticsArithmetic.*;

import model.statistics.StatisticsArithmetic;
import model.statistics.StatisticsNormalDistribution;

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

    // Cumulative area
    public void onButtonActionCalculate1(ActionEvent event) {
        StatisticsNormalDistribution cumulativeArea = new StatisticsNormalDistribution(textFieldZValue1);

        setTextField(textFieldComul1, cumulativeArea.getCumulative());
    }

    // Cumulative area compliment
    public void onButtonActionCalculate2(ActionEvent event) {
        StatisticsNormalDistribution cumulativeAreaComplim = new StatisticsNormalDistribution(textFieldZValue2);

        setTextField(textFieldComul2, cumulativeAreaComplim.getCumulativeCompliment());
    }

    // Area between the curves
    public void onButtonActionCalculate3(ActionEvent event) {
        StatisticsNormalDistribution areaBetweeCurves = new StatisticsNormalDistribution(textFieldZValue3, textFieldZValue4);

        setTextField(textFieldComul3, areaBetweeCurves.getAreaBetweenCurves());

        setTextField(textFieldAreaZValue1, roundOff(areaBetweeCurves.zValue1, 4));
        setTextField(textFieldAreaZValue2, roundOff(areaBetweeCurves.zValue2, 4));
    }

    /* Section without z-scores */

    public void onButtonActionCalculate4(ActionEvent event) {
        StatisticsNormalDistribution cumulative = new StatisticsNormalDistribution(textFieldXValue1, textFieldMean1,
                textFieldStnDev1);

        setTextField(textFieldComul4, cumulative.getCumulative());
    }

    // Cumulative area compliment
    public void onButtonActionCalculate5(ActionEvent event) {
        StatisticsNormalDistribution cumulativeCompliment = new StatisticsNormalDistribution(textFieldXValue2, textFieldMean2,
                textFieldStndDev2);

        setTextField(textFieldComul5, cumulativeCompliment.getCumulativeCompliment());

    }

    // Area between the curves
    public void onButtonActionCalculate6(ActionEvent event) {
        StatisticsNormalDistribution areaBetweenCurves = new StatisticsNormalDistribution(textFieldXValue3, textFieldXValue4,
                textFieldMean3, textFieldStnDev3);

        setTextField(textFieldAreaXValue1, roundOff(areaBetweenCurves.cumulativeProbability1, 4));
        setTextField(textFieldAreaXValue2, roundOff(areaBetweenCurves.cumulativeProbability2, 4));

        setTextField(textFieldComul6, areaBetweenCurves.getAreaBetweenCurves());
    }
}
