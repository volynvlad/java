package by.bsu.lab.basic;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * Created by vlad on 20.02.2019.
 *
 * @version version 1.0
 * @author Volynets V.O.
 */

public class TimeReport {
    /**
     *
     * Вывести фамилию разработчика, дату и время получения задания, а также
     * дату и время сдачи задания.
     *
     */

    public static void display(int year, int month, int day, int hour, int minute, int second) {

        Person developer = new Person("Vlad", "Volynets");

        try {
            Calendar startCal = Calendar.getInstance();
            startCal.set(Calendar.YEAR, year);
            startCal.set(Calendar.MONTH, month);
            startCal.set(Calendar.DAY_OF_MONTH, day);
            startCal.set(Calendar.HOUR_OF_DAY, hour);
            startCal.set(Calendar.MINUTE, minute);
            startCal.set(Calendar.SECOND, second);
            startCal.set(Calendar.MILLISECOND, 0);

            System.out.println( "\n\nРазработчик(Developer): " +
                    "\nИмя(Name)        - " + developer.getName() +
                    "\nФамилмя(Surname) - " + developer.getSurname());
            Date startDate = startCal.getTime();
            System.out.println( "\nДата и время получения задания" +
                    "\nDate and time the task was received\n" + startDate);

            Date currentTime = new Date();
            System.out.println( "\nДата и время сдачи задания" +
                    "\nDate and time of assignment\n" + currentTime);

        }
        catch (Exception e) {
            System.err.println("Произошла ошибка " + e);

        }
    }
}
