/*
* This class is where all functions in statistics are constructed. Ranging from mean to
* linear regression.
* */

package functions;

import javafx.scene.control.TextField;

import java.util.*;
import static java.lang.Math.*;

public class Statistics extends DataTypes{

    // Lists

    static List<Double> sortedDataList = new ArrayList<>();
    static Map<Double, Integer> dataListCount = new HashMap<>();

    // Doubles
    public static double count, median;
    double maxElement, minElement;

    /*
     * Constructor that only asks for a list (textArea)
     *
     * @param dataList = textArea input
     * */
    public Statistics() {

    }

    /*
    * Constructor that only asks for a list (textArea)
    *
    * @param dataList = textArea input
    * */
    public Statistics(List<Double> dataList) {
        super(dataList);
        count = dataList.size();

        // Safe sort of the dataList
        for (int i = 0; i < count; i++) {
            sortedDataList.add(dataList.get(i));
            Collections.sort(sortedDataList);
        }
    }

    /*
     * Constructor that asks for a list and textField
     *
     * @param dataList = textArea input
     * @param textField = textField input
     * */
    public Statistics(List<Double> dataList, TextField textField) {
        super(dataList, textField);
    }

    /*
     * Constructor that asks for 2 lists
     *
     * @param dataListX = textArea1 input1
     * @param dataListY = textArea2 input2
     * */
    public Statistics(List<Double> dataListX, List<Double> dataListY) {
        super(dataListX, dataListY);
    }

    /*
     * Constructor that asks for 2 lists and a textField
     *
     * @param dataListX = textArea1 input1
     * @param dataListY = textArea2 input2
     * @param textField = textField input
     * */
    public Statistics(List<Double> dataListX, List<Double> dataListY, TextField textField) {
        super(dataListX, dataListY, textField);
    }

    /*
     * Non-statistics functions
     * */

    // For rounding off values to 2 digits
    public static double roundOff(double value) {
        return round(value * 100.0) / 100.0;
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
}
