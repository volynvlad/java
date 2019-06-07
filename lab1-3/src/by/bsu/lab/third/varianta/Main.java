package by.bsu.lab.third.varianta;

import by.bsu.lab.basic.ConstantString;
import by.bsu.lab.basic.TimeReport;

import java.io.IOException;

import static by.bsu.lab.first.Main.getSize;

/**
 * Created by vlad on 23.02.2019
 *
 * @version 1.0.0
 * @author  Volynets V.O.
 */

public class Main {
    /**
     * Вариант A
     * 3. Patient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской
     * карты, Диагноз.
     * Создать массив объектов. Вывести:
     * a) список пациентов, имеющих данный диагноз;
     * b) список пациентов, номер медицинской карты которых находится в за-
     * данном интервале.
     */
    public static void main(String[] args) {
        try {
            int size; // number of patients

            System.out.println( "Введите количество больных <Enter>\n" +
                    "Enter the number of patients <Enter>");
            size = getSize();

            PatientFactory patientFactory = new PatientFactory();
            Patient[] patients = patientFactory.generatePatients(size);
            patientFactory.findByDiagnosis(patients, ConstantString.DIAGNOSIS[3]);
            patientFactory.findByMedicalCardNumber(patients, 3 ,7);

            TimeReport.display(2019,2,23,10,0,0);

        } catch (NumberFormatException e) {
            System.out.println( "Было введено не целое число или не число\n" +
                    "Was entered is not an integer or not a number\n");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
