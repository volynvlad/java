package by.bsu.lab.second.variantb;

import by.bsu.lab.basic.FormRandomNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Matrixes
 * Created by vlad on 20.02.2019.
 *
 * @version version 1.0
 * @author Volynets V.O.
 */

public class MatrixFactory {

    public Matrix setMatrixRandom(int row, int column, int min, int max) {
        Matrix matrix = new Matrix(row, column);
        FormRandomNumber formRandomNumber = new FormRandomNumber();
        for (int i = 0; i < matrix.getRow(); i++) {
            for( int j = 0; j < matrix.getColumn(); j++) {
                matrix.setNumber(i, j, formRandomNumber.generateRandomNumber(min, max));
            }
        }
        return matrix;
    }

    // increasing = true - increase sequence | = false - decreasing
    public List<Integer> increasingSequence(Matrix matrix, boolean increasing) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> tmp;
        int maxLength = 0;

        if (!matrix.isFlattenMatrix()) {
            matrix = new Matrix(1, matrix.getColumn() * matrix.getRow());
        }

        result.add(matrix.getNumber(0, 0));
        for (int i = 1; i < matrix.getColumn(); i++) {
            if (increasing) {
                if (matrix.getNumber(0, i) >= matrix.getNumber(0, i - 1)) {
                    result.add(matrix.getNumber(0, i));
                } else {
                    tmp = new ArrayList<>(result);
                    results.add(tmp);
                    result.clear();
                    result.add(matrix.getNumber(0, i));
                }
            } else {
                if (matrix.getNumber(0, i) <= matrix.getNumber(0, i - 1)) {
                    result.add(matrix.getNumber(0, i));
                } else {
                    tmp = new ArrayList<>(result);
                    results.add(tmp);
                    result.clear();
                    result.add(matrix.getNumber(0, i));
                }
            }
        }

        for (List<Integer> list : results) {
            if (list.size() > maxLength) {
                maxLength = list.size();
                result = new ArrayList<>(list);
            }
        }

        return result;
    }
}
