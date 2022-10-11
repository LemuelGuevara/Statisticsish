/*
* This class is all basic arithmetic statistics
* */

package model.statistics;

import java.util.*;
import static java.lang.Math.*;

public class StatisticsArithmetic extends StatisticsConstructor {

    // Lists

    static List<Double> sortedDataList = new ArrayList<>();
    static Map<Double, Integer> dataListCount = new HashMap<>();

    // Doubles
    static double maxElement;
    static double minElement;
    static double roundedValue;

    /*
     * Constructor that only asks for a list (textArea)
     *
     * @param dataList = textArea input
     * */
    public StatisticsArithmetic() {

    }

    /*
    * Constructor that only asks for a list (textArea)
    *
    * @param dataList = textArea input
    * */
    public StatisticsArithmetic(List<Double> dataList) {
        super(dataList);
        count = dataList.size();

        // Safe sort of the dataList
        for (int i = 0; i < count; i++) {
            sortedDataList.add(dataList.get(i));
            Collections.sort(sortedDataList);
        }
    }

    // For rounding off values to 2 digits
    public static double roundOff(double value, int sigFigures) {

        switch (sigFigures) {
            case 1 -> roundedValue = (double) round(value * 10) / 10;
            case 2 -> roundedValue = (double) round(value * 100) / 100;
            case 3 -> roundedValue = (double) round(value * 1000) / 1000;
            case 4 -> roundedValue = (double) round(value * 10000) / 10000;
        }
        return roundedValue;
    }

    /*
     * Methods below are the functions in statistics
     * All are independent of each other
     * */

    // Count
    public static double getCount() {
        count = dataList.size();

        return count;
    }

    // Count
    public static double getCount(List<Double> list) {
        count = list.size();

        return count;
    }

    // Sum
    public static double getSum() {
        double sum = 0;
        // Gets sum by iterating within the list
        // Rounds of the sum by 2 decimals
        for (Double element : dataList) {
            sum += element;
            sum = roundOff(sum, 2);
        }
        return sum;
    }

    // Sum (list)
    public static double getSum(List<Double> data) {
        double sum = 0;
        // Gets sum by iterating within the list
        // Rounds of the sum by 2 decimals
        for (Double element : data) {
            sum += element;
            sum = roundOff(sum, 2);
        }
        return sum;
    }

    // Mean
    public static double getMean() {
        double mean;

        mean = getSum() / count;
        mean = roundOff(mean, 2);
        return mean;
    }

    // Mean (list)
    public static double getMean(List<Double> list) {
        double mean;

        mean = getSum(list) / list.size();
        mean = roundOff(mean, 2);
        return mean;
    }

    // Median
    public static double getMedian() {
        double median;
        // If count is not even
        if (count % 2 != 0) {
            median = (count + 1.0) / 2;
            // Gets the nth element in the set
            median = sortedDataList.get((int) median - 1);
        } else { // Count of elements is even
            // Variables for the 1st & 2nd terms
            double firstTerm, secondTerm;

            firstTerm = count / 2.0; // nth position (1st)
            // Position of the first element in the set
            firstTerm = sortedDataList.get((int) firstTerm - 1);

            secondTerm = (count + 1.0) / 2; // nth position (2nd)
            // Position of the second element in the set
            secondTerm = sortedDataList.get((int) secondTerm);

            // Average of the 2 terms
            median = (firstTerm + secondTerm) / 2;
        }
        return median;
    }

    // Mode
    public static double getMode() {
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
    public static double getMax() {
        maxElement = Collections.max(dataList);
        return maxElement;
    }

    // Min
    public static double getMin() {
        minElement = Collections.min(dataList);
        return minElement;
    }

    // Range
    public static double getRange() {
        return getMax() - getMin();
    }

    // Variance
    public static double getVar() {
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

    // Variance (list)
    public static double getVar(List<Double> list) {
        double xElement, varSum = 0, variance;
        // Iterates through the unsorted list
        for (Double element : list) {
            // Gets the element
            // Subtracts the element from the mean
            // Differences is squared
            xElement = pow(element - getMean(list), 2);
            // Sum of the xElement
            varSum += xElement;
        }

        // Variance
        variance = varSum / (list.size() - 1);

        return variance;
    }

    // Standard Deviation
    public static double getStnDev() {
        double stnDev;
        stnDev = sqrt(getVar());

        return stnDev;
    }

    // Standard deviation (list)
    public static double getStnDev(List<Double> list) {
        double stnDev;
        stnDev = sqrt(getVar(list));

        return stnDev;
    }
}
