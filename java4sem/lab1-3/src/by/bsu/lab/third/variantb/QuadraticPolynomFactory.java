package by.bsu.lab.third.variantb;

import by.bsu.lab.basic.ComplexNumber;
import by.bsu.lab.basic.ConstantNumbers;
import by.bsu.lab.basic.FormRandomNumber;

import java.io.IOException;

/**
 * Class generation quadratic polynom
 *
 * Created by vlad on 23.02.2019
 *
 * @version version 1.0
 * @author Volynets V.O.
 */

public class QuadraticPolynomFactory {
    /**
     * generate quadratic polynoms
     * @param number of polynoms
     * @return polynoms
     */
    public QuadraticPolynom[] generateQuadraticPolynoms (int number) {
        FormRandomNumber formRandomNumber = new FormRandomNumber();

        QuadraticPolynom[] quadraticPolynom = new QuadraticPolynom[number];
        for (int i = 0; i < number; i++) {
            quadraticPolynom[i] = new QuadraticPolynom();
            ComplexNumber coef[] = new ComplexNumber[3];
            for (int j = 0; j < 3; j++) {
                coef[j] = new ComplexNumber(formRandomNumber.generateRandomNumber(ConstantNumbers.MIN_COEFFICIENT, ConstantNumbers.MAX_COEFFICIENT), 0);
            }
            quadraticPolynom[i].setCoefficents(coef);
        }
        return quadraticPolynom;
    }

    /**
     * return max root of quadratic polynoms
     * @param quadraticPolynoms quadratic polynoms
     * @return complex number max root
     * @throws IOException if one of them will not be quadratic polynoms
     */

    public ComplexNumber maxRoot (QuadraticPolynom[] quadraticPolynoms) throws IOException {
        ComplexNumber maxRoot;
        maxRoot = quadraticPolynoms[0].getRoots()[0];
        for(int i = 0; i < quadraticPolynoms.length; i++) {
            for(int j = 0; j < 2; j++) {
                if (maxRoot.isLower( quadraticPolynoms[i].getRoots()[j])) {
                    maxRoot.copy(quadraticPolynoms[i].getRoots()[j]);
                }
            }
        }

        return maxRoot;
    }

    /**
     * return min root of quadratic polynoms
     * @param quadraticPolynoms quadratic polynoms
     * @return complex number min root
     * @throws IOException if one of them will not be quadratic polynoms
     */

    public ComplexNumber minRoot (QuadraticPolynom[] quadraticPolynoms) throws IOException {
        ComplexNumber minRoot;
        minRoot = quadraticPolynoms[0].getRoots()[0];
        for(int i = 0; i < quadraticPolynoms.length; i++) {
            for(int j = 0; j < 2; j++) {
                if (minRoot.isBigger( quadraticPolynoms[i].getRoots()[j])) {
                    minRoot.copy(quadraticPolynoms[i].getRoots()[j]);
                }
            }
        }

        return minRoot;
    }
}
