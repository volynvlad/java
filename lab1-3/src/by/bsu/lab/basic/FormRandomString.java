package by.bsu.lab.basic;

/**
 * Class generation string by random
 * Created by vlad on 24.02.2019
 * @version version 1.0
 * @author Volynets V.O.
 */

public class FormRandomString {

    FormRandomNumber formRandomNumber = new FormRandomNumber();
    public String getRandomName() {
        return ConstantString.NAMES[formRandomNumber.generateRandomNumber(0, ConstantString.NAMES.length - 1)];
    }

    public String getRandomSurname() {
        return ConstantString.SNAMES[formRandomNumber.generateRandomNumber(0, ConstantString.SNAMES.length - 1)];
    }

    public String getRandomFName() {
        return ConstantString.FNAMES[formRandomNumber.generateRandomNumber(0, ConstantString.FNAMES.length - 1)];
    }

    public String getRandomAdress() {
        return ConstantString.ADDRESSES[formRandomNumber.generateRandomNumber(0, ConstantString.ADDRESSES.length - 1)];
    }

    public String getRandomPhoneNumber() {
        return ConstantString.PHONE_NUMBERS[formRandomNumber.generateRandomNumber(0, ConstantString.PHONE_NUMBERS.length -1)];
    }

    public String getRandomDiagnosis() {
        return ConstantString.DIAGNOSIS[formRandomNumber.generateRandomNumber(0, ConstantString.DIAGNOSIS.length - 1)];
    }
}
