/*
* This class is used for clearing all text fields e.g. textArea and textField
* */

package main;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class TextClearField {
    List<TextField> textFieldList;
    TextArea textArea, textArea1, textArea2;

    /*
     * Constructor asks for textArea and List
     *
     * @param textArea = textArea input
     * @param textFieldList = list of textFields
     * */
    public TextClearField(TextArea textArea, List<TextField> textFieldList) {
        this.textArea = textArea;
        this.textFieldList = textFieldList;
    }

    /*
     * Constructor asks 2 textAreas
     *
     * @param textArea1 = textArea1 input1
     * @param textArea1 = textArea2 input1
     * @param textFieldList = list of textFields
     * */
    public TextClearField(TextArea textArea1, TextArea textArea2, List<TextField> textFieldList) {
        this.textArea1 = textArea1;
        this.textArea2 = textArea2;
        this.textFieldList = textFieldList;
    }

    // Clears all textFields and 1 textArea
    public void clearField() {
        textArea.clear();
        textArea1.clear();
        textArea2.clear();

        for (TextField field : this.textFieldList) {
            field.clear();
        }
    }

    // Clears all textFields and more than 1 textArea
    public void clearField2() {
        textArea1.clear();
        textArea2.clear();

        for (TextField field : this.textFieldList) {
            field.clear();
        }
    }
}
