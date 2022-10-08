package functions;

import javafx.scene.control.TextField;

import java.util.List;

public class StatisticsStandardScore extends Statistics {
    TextField xInput1, xInput2, popMean, stnDeviation;
    double xValue, zScore, populationMeanInput, standardDeviationInput;

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
    public StatisticsStandardScore(List<Double> dataList, TextField xInput1) {
        super(dataList);
        this.xInput1 = xInput1;
    }

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param xInput2 = textField input1
     * @param popMean = texField input 2
     * @param stnDeviation = textField 3
     * */
    public StatisticsStandardScore(List<Double> dataList, TextField xInput2, TextField popMean, TextField stnDeviation) {
        super(dataList);
        this.xInput2 = xInput2;
        this.popMean = popMean;
        this.stnDeviation = stnDeviation;
    }

    /* If dataset is given */

    public double getZscoreGiven() {
        xValue = Double.parseDouble(String.valueOf(xInput1.getText()));
        zScore = (xValue - getMean()) / getStnDev();

        return zScore;
    }

    /* If dataset is not given */

    // X element/value
    public double getXValue() {
        xValue = Double.parseDouble(String.valueOf(xInput2.getText()));

        return xValue;
    }

    // Population Mean
    public double getPopMean() {
        populationMeanInput = Double.parseDouble(String.valueOf(popMean.getText()));

        return populationMeanInput;
    }

    // Standard Deviation
    public double getStandardDeviation() {
        standardDeviationInput = Double.parseDouble(String.valueOf(stnDeviation.getText()));

        return standardDeviationInput;
    }

    // Z-Score
    public double getZScore() {
        zScore = (xValue - populationMeanInput) / standardDeviationInput;

        return zScore;
    }
}
