/*
* This controller class controls the inputs and outputs of the outliers page
* */

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.TextAreaConverter;
import main.TextClearField;
import model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class OutliersController {
    @FXML private TextArea textAreaData;
    @FXML private TextField textFieldLowerOutlier;
    @FXML private TextField textFieldUpperOutlier;

    List<Double> data;
    List<TextField> outliersFields = new ArrayList<>();

    // Outliers
    public void onButtonActionCalculateOutliers(ActionEvent event) {
        // Takes a dataSet
        data = TextAreaConverter.getTextAreaData(textAreaData.getText());

        Statistics outlier = new Statistics(data);
        textFieldLowerOutlier.setText(String.valueOf(outlier.getLowerOutlier()));
        textFieldUpperOutlier.setText(String.valueOf(outlier.getUpperOutlier()));
    }

    // Clears all textFields and textArea of the outliers page
    public void onButtonActionClearOutliers(ActionEvent e) {
        outliersFields.add(textFieldLowerOutlier);
        outliersFields.add(textFieldUpperOutlier);

        TextClearField clear = new TextClearField(textAreaData, outliersFields);
        clear.clearField();
    }
}
