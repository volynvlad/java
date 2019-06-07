package by.bsu.lab.basic;

/**
 * Class of generation complex numbers
 * Created by vlad on 24.02.2019
 * @version version 1.0
 * @author Volynets V.O.
 */

public class ComplexNumberFactory {
    public ComplexNumber sum(ComplexNumber first, ComplexNumber second) {
        ComplexNumber result = new ComplexNumber();
        double realNumber = first.getRealNumber() + second.getRealNumber();
        double imagenaryNumber = first.getImaginaryNumber() + second.getImaginaryNumber();
        result.setRealNumber(realNumber);
        result.setImaginaryNumber(imagenaryNumber);
        return result;
    }
}
