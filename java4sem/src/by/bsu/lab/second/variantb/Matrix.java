package by.bsu.lab.second.variantb;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class matrix
 * Created by vlad on 20.02.2019.
 *
 * @version version 1.0
 * @author Volynets V.O.
 */

public class Matrix {
    private static AtomicInteger    nextId = new AtomicInteger();
    private long                    idMatrix;
    private int                     row;         // строки
    private int                     column;      // столбцы
    private int                     numbers[][]; // числа

    {
        idMatrix = nextId.incrementAndGet();
    }

    public Matrix() {
        row = 1;
        column = 1;
        numbers = new int[row][];
        numbers[0] = new int[column];
    }

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.numbers = new int[row][];
        for (int i = 0; i < row; i++) {
            this.numbers[i] = new int[column];
        }
    }

    public int getNumber(int i, int j) {
        return numbers[i][j];
    }

    public void setNumber(int i, int j, int number) {
        this.numbers[i][j] = number;
    }

    public long getIdMatrix() {
        return this.idMatrix;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void displayMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(numbers[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public Matrix flattenMatrix() {
        Matrix result = new Matrix(1, row * column);
        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                result.numbers[0][i * column + j] = this.numbers[i][j];
            }
        }
        return result;
    }

    public Matrix copyMatrix() {
        Matrix result = new Matrix(getRow(), getColumn());
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getColumn(); j++) {
                result.setNumber(i, j, getNumber(i, j));
            }
        }
        return result;
    }

    public boolean isFlattenMatrix() {
        return getRow() == 1;
    }

}
