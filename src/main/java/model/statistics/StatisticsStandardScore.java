package model.statistics;

import javafx.scene.control.TextField;

import java.util.List;

public class StatisticsStandardScore extends StatisticsConstructor {
    public static double xValue, standardScore, populationMeanInput, standardDeviationInput;

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param zsScoreX1 = textField input
     * */
    public StatisticsStandardScore(List<Double> dataList, TextField textField) {
        super(dataList, textField);

        xValue = Double.parseDouble(textField.getText());
        standardScore = (xValue - StatisticsArithmetic.getMean(dataList)) / StatisticsArithmetic.getStnDev(dataList);
    }

    /* If dataset is not given */

    /*
     * Constructor that asks for 3 textFields
     *
     * @param xInput2 = textField input1
     * @param popMean = texField input2
     * @param stnDeviation = textField3
     * */
    public StatisticsStandardScore(TextField textField, TextField textField2, TextField textField3) {
        super(textField, textField2, textField3);

        xValue = Double.parseDouble(textField.getText());
        populationMeanInput = Double.parseDouble(textField2.getText());
        standardDeviationInput = Double.parseDouble(textField3.getText());
    }

    // Z-Score
    public double getStandardScore() {

        standardScore = (xValue - populationMeanInput) / standardDeviationInput;

        return standardScore;
    }
}
