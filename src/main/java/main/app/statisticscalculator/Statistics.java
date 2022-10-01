/*
* This class is where all functions in statistics are constructed. Ranging from mean to
* linear regression.
* */

package main.app.statisticscalculator;

import java.util.*;

import static java.lang.Math.*;

public class Statistics {
    // Attributes that needs to be passed into the constructor
    List<Double> dataList;
    static List<Double> sortedDataList = new ArrayList<>();
    double sum = 0, mean, count, median;
    double maxElement, minElement;
    double variance, stnDev;
    // Statistics constructor class that asks for a list
    Statistics(List<Double> dataList) {
        this.dataList = dataList;

        for (Double element: this.dataList) {
            sortedDataList.add(element);
            Collections.sort(sortedDataList);
        }
    }

    /*
    * Methods below are the functions in statistics
    * */

    // For rounding off values to 2 digits
    static double roundOff(double value) {
        return round(value * 100.0) / 100.0;
    }
    // Counts the size of the data set
    String getCount() {
        count = dataList.size();
        return String.valueOf(count);
    }
    // Sum
    String getSum() {
        // Gets sum by iterating within the list
        // Rounds of the sum by 2 decimals
        for (Double element: dataList) {
            sum += element;
            sum = roundOff(sum);
        }
        return String.valueOf(sum);
    }
    // Mean
    String getMean() {
        mean = sum / count;
        mean = roundOff(mean);
        return String.valueOf(mean);
    }
     String getMedian() {
        // If count is not even
        if (count % 2 != 0) {
            median = (count + 1) / 2;
            // Gets the nth element in the set
            median = sortedDataList.get((int) median - 1);
        }
        else { // Count of elements is even
            // Variables for the 1st & 2nd terms
            double firstTerm, secondTerm;

            firstTerm = count / 2; // nth position (1st)
            // Position of the first element in the set
            firstTerm = sortedDataList.get((int) firstTerm - 1);

            secondTerm = (count + 1 ) / 2; // nth position (2nd)
            // Position of the second element in the set
            secondTerm = sortedDataList.get((int) secondTerm);

            // Average of the 2 terms
            median = (firstTerm + secondTerm) / 2;
        }
        return String.valueOf(median);
    }
    // Gets the mode or most frequent element in the set
    String getMode() {
        int freq = 1, elementCount;
        double mode = dataList.get(0);
        double element;

        // Iterates through the entire list
        for (int i = 0; i < dataList.size() - 1; i++) {
            // Gets the element
            element = dataList.get(i);
            elementCount = 0;
            for (int j = 1; j < dataList.size(); j++) {
                if (element == dataList.get(j))
                    // Increments if element == j (pos in list)
                    elementCount++;
            }
            if (elementCount > freq) {
                mode = element;
                freq = elementCount;
            }
        }
        return String.valueOf(mode);
    }
    // Gets max of data set
    String getMax() {
        maxElement = Collections.max(dataList);
        return String.valueOf(maxElement);
    }
    // Gets min of data set
    String getMin() {
        minElement = Collections.min(dataList);
        return String.valueOf(minElement);
    }
    // Gets range of data set
    String getRange() {
        return String.valueOf(maxElement - minElement);
    }

    // Gets the variance
    String getVar() {
        double xElement, varSum = 0;

        // Iterates through the unsorted data list
        for (int i = 0; i < dataList.size(); i++) {
            // Gets the element
            // Subtracts the element from the mean
            // Differences is squared
            xElement = pow(dataList.get(i) - mean, 2);
            // Sum of the xElement divided by count - 1
            varSum += xElement;
        }
        // Variance
        variance = varSum / (count - 1);

        return String.valueOf(roundOff(variance));
    }
    // Gets the standard deviation
    String getStnDev() {
        stnDev = sqrt(variance);

        return String.valueOf(stnDev);
    }
}
