package controllers.text;

import javafx.scene.control.TextField;

public class TextFieldSetter {

    public static void setTextField(TextField textField, double textFieldResults) {
        textField.setText(String.valueOf(textFieldResults));
    }
}
