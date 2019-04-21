package by.bsu.graph;

import by.bsu.сompare.Compare;

import java.util.ArrayList;

public class Graph {
    public static int[][] inceadentMatrix(ArrayList<String> list1, ArrayList<String> list2) {
        int[][] result = new int[list1.size()][list2.size()];
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (Compare.compare(list1.get(i), list2.get(j))) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }
}
