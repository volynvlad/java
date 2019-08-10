package by.bsu.remove;

import java.util.ArrayList;

public class Remover {
    public static ArrayList<String> remover(ArrayList<String> sequences, ArrayList<Integer> indexes) {
        ArrayList<String> result = new ArrayList<>();
        for (Integer i: indexes) {
            result.add(sequences.get(i));
        }
        sequences.removeAll(result);
        return sequences;
    }
}
