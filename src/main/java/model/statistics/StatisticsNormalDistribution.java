package model.statistics;

import javafx.scene.control.TextField;

import org.apache.commons.math3.distribution.NormalDistribution;

import static model.statistics.StatisticsArithmetic.roundOff;

public class StatisticsNormalDistribution extends StatisticsConstructor {
    // zValue and zValue2 are for the area between the curves
    double zValue;
    double cumulativeProbability, cumulativeCompliment, areaCurves;

    public double zValue1, zValue2;

    public double xValue, xValue1, xValue2, mean, stnDeviation;
    public double cumulativeProbability1, cumulativeProbability2;

    NormalDistribution normalDist = new NormalDistribution();

    /*
     * Constructor that initializes the class
     *
     * */
    public StatisticsNormalDistribution() {
        super();
    }

    /*
     * Constructor for P(z<a) and P(z>a) with z-values
     *
     * @param textField = zValue
     * */
    public StatisticsNormalDistribution(TextField textField) {
        super(textField);

        zValue = Double.parseDouble(textField.getText());
        cumulativeProbability = normalDist.cumulativeProbability(zValue);
    }

    /*
     * Constructor for P(z1<X<z2) with z-values
     *
     * @param textField1 = zValue 1
     * @param textField2 = zValue 2
     * */
    public StatisticsNormalDistribution(TextField textField1, TextField textField2) {
        super(textField1, textField2);

        zValue1 = Double.parseDouble(textField1.getText());
        zValue2 = Double.parseDouble(textField2.getText());

        cumulativeProbability1 = normalDist.cumulativeProbability(zValue1);
        cumulativeProbability2 = normalDist.cumulativeProbability(zValue2);
    }

    /*
     * Constructor for P(z<a) and P(z>a) with no z-value
     *
     * @param textField1 = xValue
     * @param textField2 = mean
     * @param textField3 = standard deviation
     * */
    public StatisticsNormalDistribution(TextField textField1, TextField textField2, TextField textField3) {
        super(textField1, textField2, textField3);

        xValue = Double.parseDouble(textField1.getText());
        mean = Double.parseDouble(textField2.getText());
        stnDeviation = Double.parseDouble(textField3.getText());

        NormalDistribution normalDistCumulative = new NormalDistribution(mean, stnDeviation);

        cumulativeProbability = normalDistCumulative.cumulativeProbability(xValue);
    }

    /*
     * Constructor for P(x1<Z<x2) with no z-values
     *
     * @param textField1 = xValue1
     * @param textField2 = xValue2
     * @param textField3 = mean
     * @param textField4 = standard deviation
     * */
    public StatisticsNormalDistribution(TextField textField1, TextField textField2,
                                        TextField textField3, TextField textField4) {

        super(textField1, textField2, textField3, textField4);

        xValue1 = Double.parseDouble(textField1.getText());
        xValue2 = Double.parseDouble(textField2.getText());
        mean = Double.parseDouble(textField3.getText());
        stnDeviation = Double.parseDouble(textField4.getText());

        NormalDistribution normalDistArea = new NormalDistribution(mean, stnDeviation);

        cumulativeProbability1 = normalDistArea.cumulativeProbability(xValue1);
        cumulativeProbability2 = normalDistArea.cumulativeProbability(xValue2);
    }

    // Gets the cumulative area
    public double getCumulative() {
        return roundOff(cumulativeProbability, 4);
    }

    // Gets the compliment of the cumulative area
    public double getCumulativeCompliment() {
        cumulativeCompliment = 1 - cumulativeProbability;

        return roundOff(cumulativeCompliment, 4);
    }

    // Gets the area between the curves
    public double getAreaBetweenCurves() {
        // Area between the curves
        areaCurves = cumulativeProbability2 - cumulativeProbability1;

        return roundOff(areaCurves, 4);
    }
}
