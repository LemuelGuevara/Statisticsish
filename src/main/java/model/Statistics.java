/*
* This class is where all functions in statistics are constructed. Ranging from mean to
* linear regression.
* */

package model;

import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.*;
import static java.lang.Math.*;

public class Statistics {
    // TextFields
    TextField popMean, zScoreX2, stnDeviation, zScoreX1;

    // Lists
    List<Double> dataList;
    List<Double> dataListX, dataListY;
    static List<Double> sortedDataList = new ArrayList<>();
    static Map<Double, Integer> dataListCount = new HashMap<>();

    // Doubles
    double percentile;
    public static double count, countX, countY, median;
    double maxElement, minElement;

    /*
    * Constructor that only asks for a list (textArea)
    *
    * @param dataList = textArea input
    * */
    public Statistics(List<Double> dataList) {
        this.dataList = dataList;
        count = dataList.size();

        // Safe sort of the dataList
        for (int i = 0; i < count; i++) {
            sortedDataList.add(dataList.get(i));
            Collections.sort(sortedDataList);
        }
    }

    /*
     * Constructor that only asks for a list (textArea)
     *
     * @param dataList1 = textArea input1
     * @param dataList2 = textArea input2
     * */
    public Statistics(List<Double> dataListX, List<Double> dataListY) {
        this.dataListX = dataListX;
        this.dataListY = dataListY;
        countX = dataListX.size();
        countY = dataListY.size();
    }

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param percentile = textField input
     * */
    public Statistics(List<Double> dataList, double percentile) {
        this.dataList = dataList;
        this.percentile = percentile;
        count = dataList.size();

        // Safe sort of the dataList
        for (int i = 0; i < count; i++) {
            sortedDataList.add(dataList.get(i));
            Collections.sort(sortedDataList);
        }
    }

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param zsScoreX1 = textField input
     * */
    public Statistics(List<Double> dataList, TextField zScoreX1) {
        this.dataList = dataList;
        this.zScoreX1 = zScoreX1;
        count = dataList.size();

        // Safe sort of the dataList
        for (int i = 0; i < count; i++) {
            sortedDataList.add(dataList.get(i));
            Collections.sort(sortedDataList);
        }
    }

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param zScoreX2 = textField input1
     * @param popMean = texField input 2
     * @param stnDeviation = textField 3
     * */
    public Statistics(List<Double> dataList, TextField zScoreX2, TextField popMean, TextField stnDeviation) {
        this.dataList = dataList;
        this.zScoreX2 = zScoreX2;
        this.popMean = popMean;
        this.stnDeviation = stnDeviation;
        count = dataList.size();

        // Safe sort of the dataList
        for (int i = 0; i < count; i++) {
            sortedDataList.add(dataList.get(i));
            Collections.sort(sortedDataList);
        }
    }

    /*
     * Non-statistics functions
     * */

    // For rounding off values to 2 digits
    public static double roundOff(double value) {
        return round(value * 100.0) / 100.0;
    }

    // Checks if quartile or percentile nth has a remainder
    double checkQuartPerct(double quartilePerecentile) {
        BigDecimal decimalValue = new BigDecimal(String.valueOf(quartilePerecentile));
        int intValue = decimalValue.intValue();
        String decimalValuePos = decimalValue.subtract(new BigDecimal(intValue)).toPlainString();

        // Position of elements
        Double elementPosition = dataList.get(intValue - 1);
        Double nextElementPosition = dataList.get(intValue);

        // Checks if the nth value has a remainder
        if (quartilePerecentile % 1 != 0) {
            quartilePerecentile = elementPosition + Double.parseDouble(decimalValuePos) * (nextElementPosition - elementPosition);
        }
        // If no remainder, quartilePercentile is equivalent to the elementPosition (dataList.get(intValue - 1))
        else {
            quartilePerecentile = elementPosition;
        }
        return quartilePerecentile;
    }

    /*
     * Methods below are the functions in statistics
     * All are independent of each other
     * */

    // Sum
    public double getSum() {
        double sum = 0;
        // Gets sum by iterating within the list
        // Rounds of the sum by 2 decimals
        for (Double element : dataList) {
            sum += element;
            sum = roundOff(sum);
        }
        return sum;
    }

    public double getSum(List<Double> dataListCorrel) {
        double sum = 0;
        // Gets sum by iterating within the list
        // Rounds of the sum by 2 decimals
        for (Double element : dataListCorrel) {
            sum += element;
            sum = roundOff(sum);
        }
        return sum;
    }

    // Mean
    public double getMean() {
        double mean;

        mean = getSum() / count;
        mean = roundOff(mean);
        return mean;
    }

    public double getMean(List<Double> dataListCorrel) {
        double mean;

        mean = getSum(dataListCorrel) / dataListCorrel.size();
        mean = roundOff(mean);
        return mean;
    }

    // Median
    public double getMedian() {
        // If count is not even
        if (count % 2 != 0) {
            median = (count + 1) / 2;
            // Gets the nth element in the set
            median = sortedDataList.get((int) median - 1);
        } else { // Count of elements is even
            // Variables for the 1st & 2nd terms
            double firstTerm, secondTerm;

            firstTerm = count / 2; // nth position (1st)
            // Position of the first element in the set
            firstTerm = sortedDataList.get((int) firstTerm - 1);

            secondTerm = (count + 1) / 2; // nth position (2nd)
            // Position of the second element in the set
            secondTerm = sortedDataList.get((int) secondTerm);

            // Average of the 2 terms
            median = (firstTerm + secondTerm) / 2;
        }
        return median;
    }

    // Mode
    public double getMode() {
        double result = -1;
        int frequency = -1;

        int value;

        for (Double element : dataList) {
            value = -1;

            if (dataListCount.containsKey(element)) {
                value = dataListCount.get(element);
            }
            if (value != -1) {
                value += 1;
                if (value > frequency) {
                    frequency = value;
                    result = element;
                }
                dataListCount.put(element, value);
            } else {
                dataListCount.put(element, 1);
            }
            if (frequency == 1)
                return -1;
        }
        return result;
    }

    // Max
    public double getMax() {
        maxElement = Collections.max(dataList);
        return maxElement;
    }

    // Min
    public double getMin() {
        minElement = Collections.min(dataList);
        return minElement;
    }

    // Range
    public double getRange() {
        return getMax() - getMin();
    }

    // Variance
    public double getVar() {
        double xElement, varSum = 0, variance;

        // Iterates through the unsorted data list
        for (Double element : dataList) {
            // Gets the element
            // Subtracts the element from the mean
            // Differences is squared
            xElement = pow(element - getMean(), 2);
            // Sum of the xElement
            varSum += xElement;
        }

        // Variance
        variance = varSum / (count - 1);

        return variance;
    }

    // Standard Deviation
    public double getStnDev() {
        double stnDev;

        stnDev = sqrt(getVar());

        return stnDev;
    }

    // Quartiles and percentiles
    public class QuartilePercentile {
        public static double quart1, quart2, quart3, perct;

        // Quartile 1
        public double getQuart1() {
            quart1 = 0.25 * (count + 1);
            quart1 = checkQuartPerct(quart1);

            return quart1;
        }

        // Quartile 2
        public double getQuart2() {
            quart2 = 0.50 * (count + 1);
            quart2 = checkQuartPerct(quart2);

            return quart2;
        }

        // Quartile 3
        public double getQuart3() {
            quart3 = 0.75 * (count + 1);
            quart3 = checkQuartPerct(quart3);

            return quart3;
        }

        // Percentile
        public double getPerct() {
            perct = (percentile / 100) * (count + 1);
            perct = checkQuartPerct(perct);

            return perct;
        }
    }

    // Z-Score
    public double getZscoreGiven() {
        double xInput, zScore;
        xInput = Double.parseDouble(String.valueOf(zScoreX1.getText()));
        zScore = (xInput - getMean()) / getStnDev();

        return zScore;
    }

    public class ZScore {
        static double xInput, zScore, populationMeanInput, standardDeviationInput;

        // X element/value
        public double getXValue() {
            xInput = Double.parseDouble(String.valueOf(zScoreX2.getText()));

            return xInput;
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
            zScore = (xInput - populationMeanInput) / standardDeviationInput;

            return zScore;
        }
    }

    // Outliers
    public double getLowerOutlier() {
        double lowerBound;

        QuartilePercentile lowOutlier = new QuartilePercentile();
        lowerBound = lowOutlier.getQuart1() - 1.5 * (lowOutlier.getQuart3() - lowOutlier.getQuart1());

        return lowerBound;
    }

    public double getUpperOutlier() {
        double upperBound;

        QuartilePercentile upperOutlier = new QuartilePercentile();
        upperBound = upperOutlier.getQuart3() + 1.5 * (upperOutlier.getQuart3() - upperOutlier.getQuart1());

        return upperBound;
    }

    // Correlation
    public double getCorrel() {
        double correlation, sumX, sumY, yElement = 0, productXY = 0;
        double xSquare, ySquare, xSquareSum, ySquareSum;

        List<Double> dataListXSquare = new ArrayList<>();
        List<Double> dataListYSquare = new ArrayList<>();

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

        correlation = ((countX * productXY) - (sumX * sumY)) /
                sqrt((countX * xSquareSum - pow(sumX, 2)) * ((countX * ySquareSum - pow(sumY, 2))));

        return correlation;
    }
}
