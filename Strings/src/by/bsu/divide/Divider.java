package by.bsu.divide;

import java.util.ArrayList;

public class Divider {
    public static ArrayList<String> dividerToSequences(String text) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> sequenceListNum = new ArrayList<>();
        int counter = 0;
        for(int i = 0;i < text.length(); i++) {
            if (text.charAt(i) != '.') {
                counter++;
            } else {
                sequenceListNum.add(counter + sequenceListNum.size());
            }
        }
        result.add(text.substring(0, sequenceListNum.get(0)));
        for (int i = 0;i < sequenceListNum.size() - 1;i++) {
            result.add(text.substring(sequenceListNum.get(i) + 1, sequenceListNum.get(i + 1)) + '.');
        }
        return result;
    }

    public static ArrayList<String> dividerToWords(String sequence) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> wordListNum = new ArrayList<>();
        int counter = 0;
        for (int i = 0;i < sequence.length(); i++) {
            if(sequence.charAt(i) != ' ') {
                counter++;
            } else {
                wordListNum.add(counter + wordListNum.size());
            }
        }

        result.add(sequence.substring(0, wordListNum.get(0)));
        for (int i = 0;i < wordListNum.size() - 1;i++) {
            result.add(sequence.substring(wordListNum.get(i), wordListNum.get(i + 1) - 1));
        }
        result.add(sequence.substring(wordListNum.get(wordListNum.size() - 1), sequence.length() - 1));
        return result;
    }
}
