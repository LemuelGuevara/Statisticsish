package functions;

import javafx.scene.control.TextField;

import java.util.List;

public class DataTypes {
    TextField textField;

    List<Double> dataList;
    List<Double> dataListX;
    List<Double> dataListY;

    public DataTypes() {
    }

    public DataTypes(List<Double> dataList) {
        this.dataList = dataList;
    }

    public DataTypes(List<Double> dataList, TextField textField) {
        this.dataList = dataList;
        this.textField = textField;
    }

    public DataTypes(List<Double> dataListX, List<Double> dataListY) {
        this.dataListX = dataListX;
        this.dataListY = dataListY;
    }

    public DataTypes(List<Double> dataListX, List<Double> dataListY, TextField textField) {
        this.dataListX = dataListX;
        this.dataListY = dataListY;
        this.textField = textField;
    }
}
