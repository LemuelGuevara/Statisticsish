package model.statistics;

import javafx.scene.control.TextField;

import java.util.List;

public abstract class StatisticsConstructor {
    TextField textField, textField1, textField2, textField3;

    static List<Double> dataList;
    List<Double> dataListX;
    List<Double> dataListY;

    static int count;

    public StatisticsConstructor() {
    }

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param zsScoreX1 = textField input
     * */
    public StatisticsConstructor(List<Double> dataList) {
        StatisticsConstructor.dataList = dataList;
    }

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param zsScoreX1 = textField input
     * */
    public StatisticsConstructor(List<Double> dataList, TextField textField) {
        StatisticsConstructor.dataList = dataList;
        this.textField = textField;
    }

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param zsScoreX1 = textField input
     * */
    public StatisticsConstructor(List<Double> dataListX, List<Double> dataListY) {
        this.dataListX = dataListX;
        this.dataListY = dataListY;
    }

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param zsScoreX1 = textField input
     * */
    public StatisticsConstructor(List<Double> dataListX, List<Double> dataListY, TextField textField) {
        this.dataListX = dataListX;
        this.dataListY = dataListY;
        this.textField = textField;
    }

    /*
     * Constructor that asks for a list and a double value
     *
     * @param dataList = textArea input
     * @param zsScoreX1 = textField input
     * */
    public StatisticsConstructor(TextField textField1, TextField textField2, TextField textField3) {
        this.textField1 = textField1;
        this.textField2 = textField2;
        this.textField3 = textField3;
    }
}
