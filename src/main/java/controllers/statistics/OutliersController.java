/*
* This controller class controls the inputs and outputs of the outliers page
* */

package controllers.statistics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static controllers.text.TextFieldSetter.*;
import static controllers.text.TextAreaGetter.*;
import controllers.text.TextClearField;

import model.statistics.StatisticsOutliers;

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
        data = getTextAreaData(textAreaData.getText());
        StatisticsOutliers outlier = new StatisticsOutliers(data);

       setTextField(textFieldLowerOutlier, outlier.getLowerOutlier());
       setTextField(textFieldUpperOutlier, outlier.getUpperOutlier());
    }

    // Clears all textFields and textArea of the outliers page
    public void onButtonActionClearOutliers(ActionEvent e) {
        outliersFields.add(textFieldLowerOutlier);
        outliersFields.add(textFieldUpperOutlier);

        TextClearField clear = new TextClearField();
        clear.clearField(textAreaData, outliersFields);
    }
}
