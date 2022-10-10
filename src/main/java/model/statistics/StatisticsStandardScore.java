package model.statistics;

import javafx.scene.control.TextField;

import java.util.List;

public class StatisticsStandardScore extends StatisticsConstructor {
    TextField xInput;
    public static double xValue, standardScore, populationMeanInput, standardDeviationInput;

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param zsScoreX1 = textField input
     * */
    public StatisticsStandardScore(List<Double> dataList, TextField xInput) {
        super(dataList);
        this.xInput = xInput;

        xValue = Double.parseDouble(xInput.getText());
        standardScore = (xValue - StatisticsArithmetic.getMean(dataList)) / StatisticsArithmetic.getStnDev(dataList);
    }

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param xInput2 = textField input1
     * @param popMean = texField input 2
     * @param stnDeviation = textField 3
     * */
    public StatisticsStandardScore(TextField textField1, TextField textField2, TextField textField3) {
        super(textField1, textField2, textField3);

        xValue = Double.parseDouble(String.valueOf(textField1.getText()));
        populationMeanInput = Double.parseDouble(String.valueOf(textField2.getText()));
        standardDeviationInput = Double.parseDouble(String.valueOf(textField3.getText()));
    }

    /* If dataset is given */

//    public double getStandScore() {
//        xValue = Double.parseDouble(String.valueOf(xInput1.getText()));
//        zScore = (xValue - Statistics.getMean()) / Statistics.getStnDev();
//
//        return zScore;
//    }

    /* If dataset is not given */

    // Z-Score
    public double getStandardScore() {
        standardScore = (xValue - populationMeanInput) / standardDeviationInput;

        return standardScore;
    }
}
