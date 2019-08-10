package by.bsu.lab.third.variantb;

import by.bsu.lab.basic.ComplexNumber;
import by.bsu.lab.basic.Polynom;

import java.io.IOException;

/**
 * Class quadratic polynom
 *
 * Created by vlad on 24.02.2019
 *
 * @version version 1.0
 * @author Volynets V.O.
 */

public class QuadraticPolynom {

    Polynom polynom = new Polynom(3);

    /**
     * Fing roots of polygon
     * @return complex numbers - roots
     * @throws IOException if it not a quadratic polygon
     */
    public ComplexNumber[] getRoots() throws IOException {
        // A * x^2 + b * x + C = 0
        ComplexNumber A = polynom.getCoefficents()[2];
        ComplexNumber B = polynom.getCoefficents()[1];
        ComplexNumber C = polynom.getCoefficents()[0];
        ComplexNumber roots[] = new ComplexNumber[2];
        roots[0] = new ComplexNumber();
        roots[1] = new ComplexNumber();
        if (A.isEqual(new ComplexNumber())) {
            throw new IOException("This is not a quadratic polygon!");
        } else {
            try {
                double Discriminant = B.getRealNumber() * B.getRealNumber() - 4 * A.getRealNumber() * C.getRealNumber();

                if (Discriminant == 0) {

                    roots[0].setNumber(-B.getRealNumber() / (2 * A.getRealNumber()), 0);
                    roots[1].setNumber(-B.getRealNumber() / (2 * A.getRealNumber()), 0);
                } else if (Discriminant > 0) {
                    roots[0].setNumber(-B.getRealNumber() + Math.sqrt(Discriminant) / (2 * A.getRealNumber()), 0);
                    roots[1].setNumber(-B.getRealNumber() - Math.sqrt(Discriminant) / (2 * A.getRealNumber()), 0);
                } else {
                    roots[0].setNumber(-B.getRealNumber() / (2 * A.getRealNumber()), Math.sqrt(-Discriminant) / (2 * A.getRealNumber()));
                    roots[1].setNumber(-B.getRealNumber() / (2 * A.getRealNumber()), -Math.sqrt(-Discriminant) / (2 * A.getRealNumber()));
                }
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        return roots;
    }

    /**
     * get extremum
     * @return extremum of quadratic polygon
     * @throws IOException if it not a quadratic polygon
     */

    public double getExtremum() throws IOException{
        if (polynom.getCoefficents()[2].isEqual(new ComplexNumber())) {
            throw new IOException("This is not a quadratic polynom!");
        } else {
            return -polynom.getCoefficents()[1].getRealNumber() / (2 * polynom.getCoefficents()[2].getRealNumber());
        }
    }

    public boolean hasMinimum() {
        return polynom.getCoefficents()[2].getRealNumber() > 0;
    }

    public boolean hasMaximum() {
        return polynom.getCoefficents()[2].getRealNumber() < 0;
    }

    public String increase() throws IOException{
        String result;
        if (hasMaximum()) {
            result = "(infinity ; " + getExtremum() + "]";
        } else {
            result = "[" + getExtremum() + " ; infinity)";
        }
        return result;
    }

    public String decreases() throws IOException{
        String result;
        if (hasMinimum()) {
            result = "(infinity ; " + getExtremum() + "]";
        } else {
            result = "[" + getExtremum() + " ; infinity)";
        }
        return result;
    }

    public void display() {
        polynom.display();
    }

    public void setCoefficents(ComplexNumber[] coefficents) {
        polynom.setCoefficents(coefficents);
    }
}
