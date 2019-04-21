package by.bsu.сompare;

import by.bsu.divide.Divider;

import java.util.ArrayList;

public class Compare {
    public static boolean compare(String list1, String list2) {
        ArrayList<String> words1 = Divider.dividerToWords(list1);
        ArrayList<String> words2 = Divider.dividerToWords(list2);
        for (String string1 : words1) {
            for(String string2 : words2) {
                if (string1.equals(string2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
