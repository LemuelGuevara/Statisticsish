package functions;

import javafx.scene.control.TextField;

import java.util.List;
import static java.lang.Math.*;

public class StatisticsNormalDistribution extends StatisticsStandardScore {
    double normalDist, x;

    public StatisticsNormalDistribution() {
    }

    public StatisticsNormalDistribution(List<Double> dataList, TextField textField) {
        super(dataList, textField);
    }

    public StatisticsNormalDistribution(TextField textField1, TextField textField2, TextField textField3) {
        super(textField1, textField2, textField3);
    }

    public double getNormalDist() {
        normalDist = 1 / (getStandardDeviationZ() * sqrt(2 * PI)) * (exp(pow(-(getXValueZ() - getPopMeanZ()), 2) / 2 * pow(getStandardDeviationZ(), 2)));

        return normalDist;
    }
}
