package main.app.statisticscalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextAreaConverter {
    public static List<Double> getTextAreaData(String textAreaInput) {
        // Appends textArea input into a string arraylist
        // Then converts the String arrayList into a double list
        ArrayList<String> textAreaArray = new ArrayList<>(Arrays.asList(textAreaInput.split(",")));
        List<Double> dataSetList = new ArrayList<>(textAreaArray.size());

        // Adds the input of input from the text area into the converted double list (String arrayList)
        for (int i = 0; i < textAreaArray.size(); i++) {
            dataSetList.add(Double.parseDouble(textAreaArray.get(i)));
        }
        return dataSetList;
    }
}
