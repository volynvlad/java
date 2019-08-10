package by.bsu.lab.basic;

import by.bsu.lab.basic.ConstantNumbers;

/**
 * Generate random numbers
 * Created by vlad on 19.02.2019
 * @version version 1.0
 * @author Volynets V.O.
 */

public class FormRandomNumber {
    private int number;

    public FormRandomNumber() {
        // [ -50 100]
        number = (int)(Math.random() * ((ConstantNumbers.MAX_RANDOM_INT - ConstantNumbers.MIN_RANDOM_INT) + 1) + ConstantNumbers.MIN_RANDOM_INT);
    }

    public int getNumber() {
        return number;
    }

    public int generateRandomNumber() {
        // [ -50 100]
        number = (int)(Math.random() * ((ConstantNumbers.MAX_RANDOM_INT - ConstantNumbers.MIN_RANDOM_INT) + 1) + ConstantNumbers.MIN_RANDOM_INT);
        return number;
    }
    public int generateRandomNumber(int min, int max) {
        // [ min max]
        number = (int)(Math.random() * (max - min + 1)) + min;
        return number;
    }

    public long getRandomMedicalCardNumber() {
        return ConstantNumbers.MEDICAL_CARD_NUMBERS[generateRandomNumber(0, ConstantNumbers.MEDICAL_CARD_NUMBERS.length -1)];
    }
}
