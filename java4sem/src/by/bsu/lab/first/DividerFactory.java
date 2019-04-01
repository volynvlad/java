package by.bsu.lab.first;

import by.bsu.lab.basic.FormRandomNumber;

/**
 * Generate dividers
 * Created by vlad on 19.02.2019
 * @version version 1.0
 * @author Volynets V.O.
 */

public class DividerFactory {
    public Divider[] generateDividers(int size) { // number of dividers
        FormRandomNumber randomNumber = new FormRandomNumber();
        Divider[] dividers = new Divider[size];

        for (int i = 0; i < size; i++) {
            dividers[i] = new Divider();
            int number = randomNumber.generateRandomNumber();
            try {
                dividers[i].setNumber(number);
            } catch (NullPointerException e) {
                System.out.println("NullPointerException Caught");
            }
        }
        return dividers;
    }
}
