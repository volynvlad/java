package by.bsu.lab.third.varianta;

import by.bsu.lab.basic.FormRandomString;
import by.bsu.lab.basic.FormRandomNumber;

/**
 * Class working with patients
 *
 * This class is working with patients
 *
 * @version version 1.0
 * @author Volynets V.O.
 */
public class PatientFactory {

    /**
     * generate patients
     * @param number is the number of patients
     * @return patients
     */

    public Patient[] generatePatients (int number) {
        FormRandomString formRandomString = new FormRandomString();
        FormRandomNumber formRandomNumber = new FormRandomNumber();
        Patient[] patients = new Patient[number];

        for (int i = 0; i < number; i++) {
            patients[i] = new Patient();
            patients[i].setName(formRandomString.getRandomName());
            patients[i].setSurname(formRandomString.getRandomSurname());
            patients[i].setNameAfterFather(formRandomString.getRandomFName());
            patients[i].setAdress(formRandomString.getRandomAdress());
            patients[i].setPhoneNumber(formRandomString.getRandomPhoneNumber());
            patients[i].setMedicalCardNumber(formRandomNumber.getRandomMedicalCardNumber());
            patients[i].setDiagnosis(formRandomString.getRandomDiagnosis());
        }

        return patients;
    }

    /**
     * display patients by diagnosis
     * @param patients patients
     * @param diagnosis diagnosis
     */

    public void findByDiagnosis(Patient[] patients, final String diagnosis) {
        System.out.println("Find by " + diagnosis);
        for (int i = 0;i < patients.length; i++) {
            if (patients[i].getDiagnosis().equals(diagnosis)) {
                patients[i].display();
            }
        }
    }

    /**
     * display patients by medical card number
     * @param patients patients
     * @param begin lower limit
     * @param end upper limit
     */

    public void findByMedicalCardNumber(Patient[] patients, final int begin, final int end) {
        System.out.printf("Find from %d to %d", begin, end);
        for (int i = 0;i < patients.length; i++) {
            if (patients[i].getMedicalCardNumber() >= begin && patients[i].getMedicalCardNumber() <= end) {
                patients[i].display();
            }
        }
    }
}
