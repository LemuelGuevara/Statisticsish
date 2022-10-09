package functions;

import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.List;

public class StatisticsQuartilePercentile extends Statistics{
    public double quart1, quart2, quart3, percentile;

    /*
    * Constructor that has no parameters
    * */
    public StatisticsQuartilePercentile() {
    }

    /*
    * Constructor asks for a list
    *
    * @param dataList = textArea input
    * */
    public StatisticsQuartilePercentile(List<Double> dataList) {
        // Inherits the dataList from the dataTypes class
        super(dataList);
    }

    /*
    * Constructor that asks for a list and a textField input
    *
    * @param dataList = textArea input
    * @param percentileValue = textField input
    * */
    public StatisticsQuartilePercentile(List<Double> dataList, TextField textField) {
        // Inherits the dataList from the dataTypes class
        super(dataList, textField);
    }

    // Checks if quartile or percentile nth has a remainder
    public double checkQuartPercentile(double quartilePercentile) {
        BigDecimal decimalValue = new BigDecimal(String.valueOf(quartilePercentile));
        int intValue = decimalValue.intValue();
        String decimalValuePos = decimalValue.subtract(new BigDecimal(intValue)).toPlainString();

        // Position of elements
        Double elementPosition = dataList.get(intValue - 1);
        Double nextElementPosition = dataList.get(intValue);

        // Checks if the nth value has a remainder
        if (quartilePercentile % 1 != 0) {
            quartilePercentile = elementPosition + Double.parseDouble(decimalValuePos) * (nextElementPosition - elementPosition);
        }
        // If no remainder, quartilePercentile is equivalent to the elementPosition (dataList.get(intValue - 1))
        else {
            quartilePercentile = elementPosition;
        }
        return quartilePercentile;
    }

    // Quartile 1
    public double getQuart1() {
        quart1 = 0.25 * (count + 1);
        quart1 = checkQuartPercentile(quart1);

        return quart1;
    }

    // Quartile 2
    public double getQuart2() {
        quart2 = 0.50 * (count + 1);
        quart2 = checkQuartPercentile(quart2);

        return quart2;
    }

    // Quartile 3
    public double getQuart3() {
        quart3 = 0.75 * (count + 1);
        quart3 = checkQuartPercentile(quart3);

        return quart3;
    }

    // Percentile
    public double getPercentile() {
        percentile = (Double.parseDouble(String.valueOf(textField.getText())) / 100) * (count + 1);
        percentile = checkQuartPercentile(percentile);

        return percentile;
    }
}
