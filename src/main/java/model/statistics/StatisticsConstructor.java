package model.statistics;

import javafx.scene.control.TextField;

import java.util.List;

public abstract class StatisticsConstructor {
    TextField textField, textField1, textField2, textField3;

    static List<Double> dataList;
    List<Double> dataListX;
    List<Double> dataListY;

    static int count;

    /*
     * Constructor that initializes the class
     * */
    public StatisticsConstructor() {
    }

    /*
     * Constructor that asks for a single textField
     *
     * @param textField = textField input
     * */
    public StatisticsConstructor(TextField textField) {
        this.textField = textField;
    }

    /*
     * Constructor that asks for a list and a textField
     *
     * @param dataList = textArea input
     * @param textField = textField input
     * */
    public StatisticsConstructor(List<Double> dataList) {
        StatisticsConstructor.dataList = dataList;
    }

    /*
     * Constructor that asks for a list and a textField
     *
     * @param dataList = textArea input
     * @param textField = textField input
     * */
    public StatisticsConstructor(List<Double> dataList, TextField textField) {
        StatisticsConstructor.dataList = dataList;
        this.textField = textField;
    }

    /*
     * Constructor that asks for a 2 lists
     *
     * @param dataListX = textArea input2
     * @param dataListY = textArea input2
     * */
    public StatisticsConstructor(List<Double> dataListX, List<Double> dataListY) {
        this.dataListX = dataListX;
        this.dataListY = dataListY;
    }

    /*
     * Constructor that asks for a list and a textField
     *
     * @param dataListX = textArea input2
     * @param dataListY = textArea input2
     * @param textField = textField input1
     * */
    public StatisticsConstructor(List<Double> dataListX, List<Double> dataListY, TextField textField) {
        this.dataListX = dataListX;
        this.dataListY = dataListY;
        this.textField = textField;
    }

    /*
     * Constructor that asks for 3 textFields
     *
     * @param textField1 = textField input1
     * @param textField2 = textField input2
     * @param textField3 = textField input3
     * */
    public StatisticsConstructor(TextField textField1, TextField textField2, TextField textField3) {
        this.textField1 = textField1;
        this.textField2 = textField2;
        this.textField3 = textField3;
    }
}
