package by.bsu.submatrix;

import java.util.ArrayList;

public class SubMatrix {
    private ArrayList<Integer> indexes = new ArrayList<>();
    /**
     * Get max sub matrix with all ones
     */
    public ArrayList<Integer> getIndexes(int[][] matrix) {
        while(!isOnes(subMatrix(matrix, indexes))) {
            int index = getIndex(matrix);
            indexes.add(index);
        }

        return indexes;
    }

    private boolean isOnes(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int i : matrix1) {
                if (i != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] columnSum(int[][] matrix) {
        /*
         * return array of sums of each column
         */
        int[] result = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            result[i] = 0;
            for(int j = 0; j < matrix[i].length; j++) {
                result[i] += matrix[i][j];
            }
        }
        return result;
    }

    private int getIndex(int[][] matrix) {
        /*
         * get the index of the lowest sum of array
         */
        int[] columnsList = columnSum(matrix);
        int min = columnsList[0];
        int index = 0;
        for (int i = 1; i < columnsList.length; i++) {
            if (min > columnsList[i]) {
                min = columnsList[i];
                index = i;
            }
        }
        return index;
    }

    private int[][] subMatrix(int[][] matrix, ArrayList<Integer> indexes) {
        /*
         * remove column and row with index - index
         */
        ArrayList<Integer> list = new ArrayList<>();
        int[][] result = new int[matrix.length - indexes.size()][matrix.length - indexes.size()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!(indexes.contains(i) || indexes.contains(j))) {
                    list.add(matrix[i][j]);
                }
            }
        }
        for (int i = 0; i < matrix.length - indexes.size(); i++) {
            for (int j = 0; j < matrix[i].length - indexes.size(); j++) {
                result[i][j] = list.get(j + (matrix.length - indexes.size()) * i);
            }
        }
        return result;
    }
}
