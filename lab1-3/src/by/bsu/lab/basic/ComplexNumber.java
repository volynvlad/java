package by.bsu.lab.basic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class of Complex numbers
 * Created by vlad on 24.02.2019
 * @version version 1.0
 * @author Volynets V.O.
 */

public class ComplexNumber {
    private static AtomicInteger    nextId = new AtomicInteger();
    private long                    idComplexNumber;
    private double                  realNumber;
    private double                  imaginaryNumber;
    {
        idComplexNumber = nextId.incrementAndGet();
    }

    public ComplexNumber() {
        realNumber = 0;
        imaginaryNumber = 0;
    }

    public ComplexNumber(double realNumber, double imaginaryNumber) {
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    public ComplexNumber(ComplexNumber complexNumber) {
        this.idComplexNumber = complexNumber.idComplexNumber;
        this.realNumber = complexNumber.realNumber;
        this.imaginaryNumber = complexNumber.imaginaryNumber;
    }

    public long getIdComplexNumber() {
        return idComplexNumber;
    }

    public double getRealNumber() {
        return realNumber;
    }

    public void setRealNumber(double realNumber) {
        this.realNumber = realNumber;
    }

    public double getImaginaryNumber() {
        return imaginaryNumber;
    }

    public void setImaginaryNumber(double imaginaryNumber) {
        this.imaginaryNumber = imaginaryNumber;
    }

    public void setNumber (double realNumber, double imaginaryNumber) {
        this.realNumber      = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    public void setNumber (ComplexNumber complexNumber) {
        this.realNumber         = complexNumber.realNumber;
        this.imaginaryNumber    = complexNumber.imaginaryNumber;
    }

    public void display () {
        ComplexNumber zero = new ComplexNumber();
        if (this.isEqual(zero)) {
            System.out.print(0);
        } else {
            if (realNumber != 0) {
                if (realNumber > 0) {
                    System.out.print(realNumber);
                } else {
                    System.out.printf(" - %.2f" ,-realNumber);
                }
            }
            if (imaginaryNumber != 0) {
                if (imaginaryNumber > 0) {
                    System.out.printf(" + i * %.2f", imaginaryNumber);
                } else {
                    System.out.printf(" - i * %.2f", -imaginaryNumber);
                }
            }
        }
    }

    public boolean isBigger(ComplexNumber complexNumber) {
        /**
         * return true if bigger else false
         * and false if can't be compare
         */
        if (this.imaginaryNumber == 0 && complexNumber.imaginaryNumber == 0) {
            return this.realNumber > complexNumber.realNumber;
        } else {
            return false;
        }
    }

    public boolean isLower(ComplexNumber complexNumber) {
        /**
         * return true if lower else false
         * and false if can't be compare
         */
        if (this.imaginaryNumber == 0 && complexNumber.imaginaryNumber == 0) {
            return this.realNumber < complexNumber.realNumber;
        } else {
            return false;
        }
    }

    public boolean isEqual(ComplexNumber complexNumber) {
        if ( this.realNumber == complexNumber.realNumber && this.imaginaryNumber == complexNumber.imaginaryNumber){
            return true;
        } else {
            return false;
        }
    }

    public void copy(ComplexNumber complexNumber) {
        this.realNumber         = complexNumber.realNumber;
        this.imaginaryNumber    = complexNumber.imaginaryNumber;
    }

    public boolean hasImaginaryPart () {
        return this.imaginaryNumber != 0;
    }

    public boolean hasRealPart () {
        return this.realNumber != 0;
    }
}
