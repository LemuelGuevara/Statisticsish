/*
* This class is used for converting the textArea input (String) into a double
* It then puts it on a list
* */

package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextAreaConverter {
    public static List<Double> getTextAreaData(String textAreaInput) {
        // textArea array list
        ArrayList<String> textAreaArray = new ArrayList<>();

        // Checks if text area contains comma
        if (textAreaInput.contains(",")) {
            textAreaArray.addAll((Arrays.asList(textAreaInput.split(","))));
        }
        // Checks also if it contains white spaces between the elements
        else if (textAreaInput.contains(" ")) {
            textAreaArray.addAll((Arrays.asList(textAreaInput.split(" "))));
        }

        // List dataSet
        List<Double> dataSetList = new ArrayList<>(textAreaArray.size());

        // Adds the input of input from the text area into the converted double list (String arrayList)
        for (int i = 0; i < textAreaArray.size(); i++) {
            dataSetList.add(Double.parseDouble(textAreaArray.get(i)));
        }
        return dataSetList;
    }
}
