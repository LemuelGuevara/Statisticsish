package model.statistics;

import java.util.List;

public class StatisticsOutliers extends StatisticsQuartilePercentile {
    double lowerBound, upperBound;

    // Constructors that passes in a list from the quartile/percentile class
    StatisticsQuartilePercentile lowOutlier = new StatisticsQuartilePercentile(dataList);
    StatisticsQuartilePercentile upperOutlier = new StatisticsQuartilePercentile(dataList);

    /*
    * Constructor inherits the list<double> from the statistics class
    *
    * @param data= textArea input
    * */
    public StatisticsOutliers(List<Double> data) {
        super(data);
    }

    // Outliers
    public double getLowerOutlier() {
        lowerBound = lowOutlier.getQuart1() - 1.5 * (lowOutlier.getQuart3() - lowOutlier.getQuart1());

        return lowerBound;
    }

    public double getUpperOutlier() {
        upperBound = upperOutlier.getQuart3() + 1.5 * (upperOutlier.getQuart3() - upperOutlier.getQuart1());

        return upperBound;
    }
}
