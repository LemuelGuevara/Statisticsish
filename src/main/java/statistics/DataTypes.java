package statistics;

import javafx.scene.control.TextField;

import java.util.List;

public class DataTypes {
    TextField textField;
    TextField textField1, textField2, textField3;

    List<Double> dataList;
    List<Double> dataListX;
    List<Double> dataListY;

    public DataTypes() {
    }

    public DataTypes(List<Double> dataList) {
        this.dataList = dataList;
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

    public DataTypes(TextField textField1, TextField textField2, TextField textField3) {
        this.textField1 = textField1;
        this.textField2 = textField2;
        this.textField3 = textField3;
    }
}
