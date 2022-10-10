package model.statistics;

import javafx.scene.control.TextField;

import java.util.List;
import static java.lang.Math.*;

public class StatisticsNormalDistribution extends StatisticsStandardScore {
    public static double normalDist;

    public StatisticsNormalDistribution(List<Double> dataList, TextField textField) {
        super(dataList, textField);

        xValue = Double.parseDouble(textField.getText());
        normalDist =  exp(((-1 * pow(xValue - StatisticsArithmetic.getMean(dataList), 2)) /
                (2 * pow(StatisticsArithmetic.getStnDev(), 2)))) /
                StatisticsArithmetic.getStnDev(dataList) * sqrt(2 * PI);
    }

    public StatisticsNormalDistribution(TextField textField1, TextField textField2, TextField textField3) {
        super(textField1, textField2, textField3);

        xValue = Double.parseDouble(textField1.getText());
    }

    public double getNormalDist() {
        normalDist = exp(((-1 * pow(xValue - populationMeanInput, 2)) / (2 * pow(standardDeviationInput, 2)))) / standardDeviationInput * sqrt(2 * PI);

        return normalDist;
    }
}
