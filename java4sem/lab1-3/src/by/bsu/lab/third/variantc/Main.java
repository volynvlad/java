package by.bsu.lab.third.variantc;

import by.bsu.lab.basic.Polynom;
import by.bsu.lab.basic.TimeReport;

import java.io.IOException;

import static by.bsu.lab.first.Main.getSize;

/**
 * Created by vlad on 24.02.2019
 *
 * @version 1.0.0
 * @author  Volynets V.O.
 */

public class Main {

    /**
     * Вариант C
     * 3. Определить класс Полином с коэффициентами типа Комплексное число.
     * Объявить массив/список/множество из m полиномов и определить сумму
     * полиномов массива.
     */

    public static void main(String[] args) throws IOException {
        int size;
        PolynomFactory polynomFactory = new PolynomFactory();

        System.out.println("Enter the number of polynoms and press <Enter>");
        size = getSize();
        Polynom[] polynoms;
        polynoms = polynomFactory.generatePolynoms(size);

        for (int i = 0; i < size; i++) {
            polynoms[i].display();
        }

        Polynom sum = polynomFactory.sum(polynoms);
        System.out.println("================================");
        System.out.println("Result polygon");
        sum.display();

        TimeReport.display(2019,2,23,10,0,0);
    }
}
