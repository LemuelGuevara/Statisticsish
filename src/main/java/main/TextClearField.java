/*
* This class is used for clearing all text fields e.g. textArea and textField
* */

package main;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class TextClearField {

    /*
     * Constructor asks for and List
     *
     * @param textFieldList = list of textFields
     * */
    public TextClearField() {
    }

    // Clears textFields only
    public void clearField(List<TextField> textFieldList) {

        for (TextField field : textFieldList) {
            field.clear();
        }
    }

    // Clears all textFields and 1 textArea
    public void clearField(TextArea textArea, List<TextField> textFieldList) {
        textArea.clear();

        for (TextField field : textFieldList) {
            field.clear();
        }
    }

    // Clears all textFields and more than 1 textArea
    public void clearField(TextArea textArea1, TextArea textArea2, List<TextField> textFieldList) {
        textArea1.clear();
        textArea2.clear();

        for (TextField field : textFieldList) {
            field.clear();
        }
    }
}
