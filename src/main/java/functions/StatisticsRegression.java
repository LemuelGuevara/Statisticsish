package functions;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class StatisticsRegression extends Statistics {
    double correlation, sumX, sumY, countX, countY, yElement = 0, productXY = 0;
    double xSquare, ySquare, xSquareSum, ySquareSum;
    double linearRegression, regressionSlope, regressionYIntercept, xElement;

    List<Double> dataListXSquare = new ArrayList<>();
    List<Double> dataListYSquare = new ArrayList<>();

    /*
     * Constructor asks for 2 lists
     *
     * @param dataListX = textArea1 input1
     * @param dataListY = textArea2 input2
     * */
    public StatisticsRegression(List<Double> dataListX, List<Double> dataListY) {
        super(dataListX, dataListY);
        countX = dataListX.size();
        countY = dataListY.size();
        xYSquares();
    }

    /*
     * Constructor asks for 2 lists and a textField
     *
     * @param dataListX = textArea1 input1
     * @param dataListY = textArea2 input2
     * @param xValue = textField input
     * */
    public StatisticsRegression(List<Double> dataListX, List<Double> dataListY, TextField textField) {
        super(dataListX, dataListY, textField);
        countX = dataListX.size();
        countY = dataListY.size();
        xYSquares();
    }

    // Gets the sum of square, squares, and product of x * y
    private void xYSquares() {
        // Sum of s(x * y)
        for (int i = 0; i < countX; i++) {
            for (int j = 0; j < countY; j++) {
                yElement = dataListY.get(i);
            }
            productXY += dataListX.get(i) * yElement;

            // Squares the elements
            xSquare = pow(dataListX.get(i), 2);
            ySquare = pow(yElement, 2);

            // Adds to the lists
            dataListXSquare.add(xSquare);
            dataListYSquare.add(ySquare);
        }

        // Sum of x and y square
        xSquareSum = getSum(dataListXSquare);
        ySquareSum = getSum(dataListYSquare);

        // Sum of the raw data list
        sumX = getSum(dataListX);
        sumY = getSum(dataListY);
    }

    // Correlation
    public double getCorrelation() {
        correlation = ((countX * productXY) - (sumX * sumY)) /
                sqrt((countX * xSquareSum - pow(sumX, 2)) * ((countX * ySquareSum - pow(sumY, 2))));

        return correlation;
    }

    // Linear Regression
    public double getLinearRegression() {
        // lineaRegression(a) = regressionYIntercept(a) - regressionSlope(b) * xElement(x)

        // (x)
        xElement = Double.parseDouble(textField.getText());

        // (a)
        regressionYIntercept = (sumY * xSquareSum - sumX * productXY) / (countX * xSquareSum - pow(sumX, 2));
        // (b)
        regressionSlope = (countX * productXY - sumX * sumY) / (countX * xSquareSum - pow(sumX, 2));
        // (y)
        linearRegression = regressionYIntercept + (regressionSlope * xElement);

        return linearRegression;
    }
}
