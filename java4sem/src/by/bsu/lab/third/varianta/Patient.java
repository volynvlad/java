package by.bsu.lab.third.varianta;

import by.bsu.lab.basic.Person;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class patient
 *
 * Created by vlad on 23.02.2019
 *
 * @version version 1.0
 * @author Volynets V.O.
 */

public class Patient extends Person {
    private static AtomicInteger    nextId = new AtomicInteger();
    private long                    idPatient;
    private String                  adress;
    private String                  phoneNumber;
    private long                    medicalCardNumber;
    private String                  diagnosis;

    {
        idPatient = nextId.incrementAndGet();
    }

    public long getIdPatient() {
        return idPatient;
    }

    public Patient(){}

    public Patient(String name, String surname, String nameAfterFather, String adress, String phoneNumber, long medicalCardNumber, String diagnosis) {
        super(name, surname, nameAfterFather);
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public void setMedicalCardNumber(long medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }



    public void display() {
        System.out.println("Id patient:              " + idPatient);
        System.out.printf("Name:                    %s\n", name);
        System.out.printf("Surname:                 %s\n", surname);
        System.out.printf("Name after father        %s\n", nameAfterFather);
        System.out.printf("Adress:                  %s\n", adress);
        System.out.printf("Phone number:            %s\n", phoneNumber);
        System.out.println("Medical card number:     " + medicalCardNumber);
        System.out.printf("Diagnosis:               %s\n", diagnosis);
        System.out.println("=================================");
    }

    @Override
    public String toString() {
        return  idPatient + ": " + name + " " + surname + " " + nameAfterFather +
                adress + " " + phoneNumber + " " + medicalCardNumber + " " + diagnosis + "\n";
    }
}
