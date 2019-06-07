package by.bsu.lab.third.variantb;

import by.bsu.lab.basic.ComplexNumber;
import by.bsu.lab.basic.TimeReport;

import java.io.IOException;

import static by.bsu.lab.first.Main.getSize;

/**
 * Created by vlad on 23.02.2019
 *
 * @version 1.0.0
 * @author  Volynets V.O.
 */

public class Main {

    /**
     * Вариант B
     * 3. Определить класс Квадратное уравнение. Реализовать методы для поиска
     * корней, экстремумов, а также интервалов убывания/возрастания. Создать
     * массив/список/множество объектов и определить наибольшие и наимень-
     * шие по значению корни.
     */

    public static void main(String[] args) throws IOException {
        int size;
        QuadraticPolynomFactory quadraticPolynomFactory = new QuadraticPolynomFactory();


        System.out.println("Enter the number of polynoms and press <Enter>");
        size = getSize();
        QuadraticPolynom[] quadraticPolynoms;
        quadraticPolynoms = quadraticPolynomFactory.generateQuadraticPolynoms(size);

        for (int i = 0; i < size; i++) {
            quadraticPolynoms[i].display();
            ComplexNumber[] complexNumbers;
            complexNumbers = quadraticPolynoms[i].getRoots();
            System.out.println("Roots:");
            System.out.print("x1 = ");
            complexNumbers[0].display();
            System.out.println();
            System.out.print("x2 = ");
            complexNumbers[1].display();
            System.out.println();
        }

        ComplexNumber biggestRoot = quadraticPolynomFactory.maxRoot(quadraticPolynoms);
        ComplexNumber lowestRoot = quadraticPolynomFactory.minRoot(quadraticPolynoms);

        System.out.println("\n========================\n");
        System.out.println("\nBiggest root: ");
        biggestRoot.display();
        System.out.println("\nLowest root: ");
        lowestRoot.display();

        TimeReport.display(2019,2,23,10,0,0);
    }
}
