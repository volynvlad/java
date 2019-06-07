package by.bsu.lab.third.variantc;

import by.bsu.lab.basic.*;

/**
 * Class generation polymons
 *
 * Created by vlad on 24.02.2019
 *
 * @version version 1.0
 * @author Volynets V.O.
 */

public class PolynomFactory {
    public Polynom[] generatePolynoms (int number) {
        FormRandomNumber formRandomNumber = new FormRandomNumber();
        FormRandomNumber degreeRandom = new FormRandomNumber();

        Polynom[] polynoms = new Polynom[number];
        int degree;
        for (int i = 0; i < number; i++) {
            degree = degreeRandom.generateRandomNumber(2, 5);
            ComplexNumber[] coef = new ComplexNumber[degree];
            polynoms[i] = new Polynom(degree);
            for (int j = 0; j < degree; j++) {
                coef[j] = new ComplexNumber(formRandomNumber.generateRandomNumber(ConstantNumbers.MIN_COEFFICIENT, ConstantNumbers.MAX_COEFFICIENT), 0);
            }
            polynoms[i].setCoefficents(coef);
        }
        return polynoms;
    }

    public Polynom sum (Polynom[] polynoms) {
        ComplexNumberFactory complexNumberFactory = new ComplexNumberFactory();
        int maxDegree = polynoms[0].getDegree();
        for (int i = 1; i < polynoms.length; i++) {
            if (maxDegree < polynoms[i].getDegree()) {
                maxDegree = polynoms[i].getDegree();
            }
        }

        Polynom resultPolygon = new Polynom(maxDegree);

        for (int j = 0; j < maxDegree; j++) {
            ComplexNumber resultNumber = new ComplexNumber();
            for (int i = 0; i < polynoms.length; i++) {
                if(polynoms[i].getDegree() >= j) {
                    resultNumber = complexNumberFactory.sum(resultNumber, polynoms[i].getCoefficents()[j]);
                }
                resultPolygon.setCoefficent(resultNumber, j);
            }
        }
        return resultPolygon;
    }
}
