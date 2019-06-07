package by.bsu.lab.second.variantb;

import by.bsu.lab.basic.TimeReport;

import java.io.IOException;

/**
 * Created by vlad on 20.02.2019.
 *
 * @version version 1.0
 * @author Volynets V.O.
 */

public class Main {

    /**
     * Задания к главе 2
     * Вариант B
     * Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элемен-
     * тов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
     *
     * 3. Найти и вывести наибольшее число возрастающих (убывающих) эле-
     * ментов матрицы, идущих подряд.
     */

    public static void main(String[] args) {
        try {
            int n; // matrix dimension n x n
            MatrixFactory matrixFactory = new MatrixFactory();

            System.out.println( "Введите размерность матрицы (n x n) и нажмите <Enter>\n" +
                    "Enter dimension of the matrix (n x n) and press <Enter>");
            n = getN();

            Matrix matrix;
            matrix = matrixFactory.setMatrixRandom(n, n, -n, n);
            System.out.println("Matrix");
            matrix.displayMatrix();

            Matrix flattenMatrix;
            flattenMatrix = matrix.flattenMatrix();
            System.out.println("Flatten matrix");
            flattenMatrix.displayMatrix();

            System.out.println("The largest number of increasing elements: " + matrixFactory.increasingSequence(flattenMatrix, true));
            System.out.println("The largest number of decreasing elements: " + matrixFactory.increasingSequence(flattenMatrix, false));

            TimeReport.display(2019, 1,19,14,0,0); // когда задание получено

        } catch (NumberFormatException e) {
            System.out.println( "Было введено не целое число или не число\n" +
                    "Was entered is not an integer or not a number\n");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getN() throws IOException {
        int n = by.bsu.lab.first.Main.getSize();

        System.out.printf("number = %d\n", n);
        return n;
    }
}
