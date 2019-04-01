package by.bsu.lab.basic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class of polynom
 * @version version 1.0
 * @author Volynets V.O.
 */

public class Polynom {
    private static AtomicInteger    nextId = new AtomicInteger();
    private long                    idPolynom;
    private ComplexNumber[]         coefficents;
    private int                     degree;

    {
        idPolynom = nextId.incrementAndGet();
    }

    public Polynom() {
        degree = 1;
        coefficents = new ComplexNumber[degree];
        coefficents[0] = new ComplexNumber();
    }

    public Polynom(int degree) {
        coefficents = new ComplexNumber[degree + 1];
        this.degree = degree;
        for(int i = 0; i <= degree; i++) {
            coefficents[i] = new ComplexNumber();
        }
    }

    public Polynom(ComplexNumber[] coefficents) {
        degree = coefficents.length;
        for (int i = 0; i < coefficents.length; i++) {
            this.coefficents[i].copy(coefficents[i]);
        }
    }

    public long getIdPolynom() {
        return idPolynom;
    }

    public ComplexNumber[] getCoefficents() {
        return coefficents;
    }

    public void setCoefficents(ComplexNumber[] coefficents) {
        for (int i = 0; i < degree; i++) {
            this.coefficents[i].copy(coefficents[i]);
        }
    }

    public void setCoefficent(double realNumber, double imagenaryNumber, int number) {
        this.coefficents[number].setNumber(realNumber, imagenaryNumber);
    }

    public void setCoefficent(ComplexNumber coefficent, int number) {
        this.coefficents[number].setNumber(coefficent);
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void display() {
        ComplexNumber zero = new ComplexNumber();
        boolean isZero = true;
        for (int i = 0; i < degree; i++) {
            if (!this.coefficents[i].isEqual(zero)) {
                isZero = false;
            }
        }
        if (!isZero) {
            for (int i = 0; i < degree; i++) {
                if (!coefficents[i].isEqual(zero)) { // != 0
                    if (coefficents[i].isBigger(zero)) { // > 0
                        boolean flag = true;
                        flag = coefficents[i].isEqual(zero) && flag;
                        if (flag) {
                            System.out.print(" + ");
                        }
                    }
                    if (i == 0) {
                        coefficents[0].display();
                    } else if (i == 1) {
                        if (coefficents[i].getRealNumber() > 0) {
                            System.out.print(" + ");
                        }
                        if (!coefficents[1].isEqual(new ComplexNumber(1.0, 0))) {
                            coefficents[1].display();
                            System.out.print(" * ");
                        }
                        System.out.print(" x ");
                    } else {
                        if (coefficents[i].getRealNumber() > 0) {
                            System.out.print(" + ");
                        }
                        if (!coefficents[i].isEqual(new ComplexNumber(1.0, 0))) {
                            coefficents[i].display();
                            System.out.print(" * ");
                        }
                        System.out.print(" x ^ " + i);
                    }

                }
            }
        } else {
            System.out.print(0);
        }
        System.out.println();
    }
}
