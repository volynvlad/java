package by.bsu.lab.second.varianta;

import java.util.ArrayList;

/**
 * Working with strings
 * Created by vlad on 20.02.2019.
 *
 * @version version 1.0
 * @author Volynets V.O.
 */

public class StringParser {
    public double averageStringsLength(StringConsole[] stringConsoles) {
        double result = 0;
        int number = stringConsoles.length; // количество строк
        for (int i = 0; i < number; i++) {
            result = result + stringConsoles[i].getLength();
        }
        result = result / number;
        return result;
    }

    public ArrayList<StringConsole> lessThanAverageLength(StringConsole[] stringConsoles) {
        int number = stringConsoles.length; // количество строк
        double averageStringLength = averageStringsLength(stringConsoles);
        ArrayList<StringConsole> stringConsoleArrayList = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            if(stringConsoles[i].getLength() <= averageStringLength) {
                stringConsoleArrayList.add(stringConsoles[i]);
            }
        }
        return stringConsoleArrayList;
    }

    public ArrayList<StringConsole> moreThanAverageLength(StringConsole[] stringConsoles) {
        int number = stringConsoles.length; // количество строк
        double averageStringLength = averageStringsLength(stringConsoles);
        ArrayList<StringConsole> stringConsoleArrayList = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            if(stringConsoles[i].getLength() >= averageStringLength) {
                stringConsoleArrayList.add(stringConsoles[i]);
            }
        }
        return stringConsoleArrayList;
    }
}
