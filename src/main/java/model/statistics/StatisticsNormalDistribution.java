package model.statistics;

import javafx.scene.control.TextField;

import org.apache.commons.math3.distribution.NormalDistribution;

import static model.statistics.StatisticsArithmetic.roundOff;

public class StatisticsNormalDistribution extends StatisticsConstructor {
    // zValue and zValue2 are for the area between the curves
    double zValueCumul, zValueCumulComplim;
    double cumulative, cumulativeCompliment, areaCurves;

    public double zValue1, zValue2;
    public double cumul1, cumul2;

    public double xValue, xValue1, xValue2, mean, stnDeviation, cumuliProbability;
    public double cumulativeProbability1, cumulativeProbability2;

    /*
     * Constructor that initializes the class
     *
     * */
    public StatisticsNormalDistribution() {
    }

    /*
     * Constructor that asks for 3 textFields
     *
     * @param textField1 = textField input1
     * @param textField2 = textField input2
     * @param textField3 = textField input3
     * */
    public StatisticsNormalDistribution(TextField textField1, TextField textField2, TextField textField3) {
        super(textField1, textField2, textField3);

        xValue = Double.parseDouble(textField1.getText());
        mean = Double.parseDouble(textField2.getText());
        stnDeviation = Double.parseDouble(textField3.getText());

        NormalDistribution normalDistStn1 =  new NormalDistribution(mean, stnDeviation);
        cumuliProbability = normalDistStn1.cumulativeProbability(xValue);
    }

    /*
     * Constructor that asks for 3 textFields
     *
     * @param textField1 = textField input1
     * @param textField2 = textField input2
     * @param textField3 = textField input3
     * */
    public StatisticsNormalDistribution(TextField textField1, TextField textField2,
                                        TextField textField3, TextField textField4) {

        super(textField1, textField2, textField3, textField4);

        xValue1 = Double.parseDouble(textField1.getText());
        xValue2 = Double.parseDouble(textField2.getText());
        mean = Double.parseDouble(textField3.getText());
        stnDeviation = Double.parseDouble(textField4.getText());

        NormalDistribution normalDistStn2 =  new NormalDistribution(mean, stnDeviation);
        cumulativeProbability1 = normalDistStn2.cumulativeProbability(xValue1);
        cumulativeProbability2 = normalDistStn2.cumulativeProbability(xValue2);
    }

    NormalDistribution normalDist = new NormalDistribution();

    /*
    * Section with z-scores
    * */

    // Gets the cumulative area
    public double getCumulative(TextField textField) {
        zValueCumul = Double.parseDouble(textField.getText());
        cumulative = normalDist.cumulativeProbability(zValueCumul);

        return roundOff(cumulative, 4);
    }

    // Gets the compliment of the cumulative area
    public double getCumulativeCompliment(TextField textField) {
        zValueCumulComplim = Double.parseDouble(textField.getText());

        cumulativeCompliment = 1 - normalDist.cumulativeProbability(zValueCumulComplim);

        return roundOff(cumulativeCompliment, 4);
    }

    // Gets the area between the curves
    public double getAreaBetweenCurves(TextField textFieldZ1, TextField textFieldZ2) {

        // Z-values
        zValue1 = Double.parseDouble(textFieldZ1.getText());
        zValue2 = Double.parseDouble(textFieldZ2.getText());

        // Cumulative areas
        cumul1 = normalDist.cumulativeProbability(zValue1);
        cumul2 = normalDist.cumulativeProbability(zValue2);

        // Area between the curves
        areaCurves = cumul2 - cumul1;

        return roundOff(areaCurves, 4);
    }

    /*
    * Section with no z-scores
    * */

    // Gets the cumulative area
    public double getCumulative() {
        cumulative = cumuliProbability;

        return roundOff(cumulative, 4);
    }

    // Gets the compliment of the cumulative area
    public double getCumulativeCompliment() {
        cumulativeCompliment = 1 - cumuliProbability;

        return roundOff(cumulativeCompliment, 4);
    }

    // Gets the area between the curves
    public double getAreaBetweenCurves() {
        // Area between the curves
        areaCurves = cumulativeProbability2 - cumulativeProbability1;

        return roundOff(areaCurves, 4);
    }
}
