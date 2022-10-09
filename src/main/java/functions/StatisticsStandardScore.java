package functions;

import javafx.scene.control.TextField;

import java.util.List;

public class StatisticsStandardScore extends Statistics {
    double xValue1, xValue2, zScore, populationMeanInput, standardDeviationInput;

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param zsScoreX1 = textField input
     * */
    public StatisticsStandardScore() {
    }

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param zsScoreX1 = textField input
     * */
    public StatisticsStandardScore(List<Double> dataList, TextField textField) {
        super(dataList, textField);
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

    }

    /* If dataset is given */

    public double getZscoreGiven() {
        xValue1 = Double.parseDouble(String.valueOf(textField.getText()));
        zScore = (xValue1 - getMean()) / getStnDev();
        double m = getMean();
        double stn = getStnDev();

        return m;
    }

    /* If dataset is not given */

    // X element/value
    public double getXValueZ() {
        xValue2 = Double.parseDouble(String.valueOf(textField1.getText()));

        return xValue2;
    }

    // Population Mean
    public double getPopMeanZ() {
        populationMeanInput = Double.parseDouble(String.valueOf(textField2.getText()));

        return populationMeanInput;
    }

    // Standard Deviation
    public double getStandardDeviationZ() {
        standardDeviationInput = Double.parseDouble(String.valueOf(textField3.getText()));

        return standardDeviationInput;
    }

    // Z-Score
    public double getZScore() {
        zScore = (xValue2 - populationMeanInput) / standardDeviationInput;

        return zScore;
    }
}
