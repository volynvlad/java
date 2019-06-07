package by.bsu.lab.second.varianta;


import by.bsu.lab.basic.TimeReport;

import java.io.IOException;
import java.util.List;

/**
 * Created by vlad on 20.02.2019.
 *
 * @version version 1.0
 * @author Volynets V.O.
 */

public class Main {

    /**
     * Задания к главе 2
     * Вариант A
     * В приведенных ниже заданиях необходимо вывести внизу фамилию разра-
     * ботчика, дату и время получения задания, а также дату и время сдачи задания.
     * Для получения последней даты и времени следует использовать класс Date.
     * Добавить комментарии в программы в виде ... , извлечь эту
     * документацию в
     * HTML-
     * файл и
     * просмотреть полученную
     * страницу Web-
     * браузером .
     *
     * 3. Ввести n строк с консоли. Вывести на консоль те строки,
     * длина которых меньше (больше) средней, а также длину.
     */

    public static void main(String[] args) {
        try {
            System.out.println( "Введите количество требуемых строк и нажмите <Enter>\n" +
                    "Enter the required number of strings and press <Enter>");
            int number = by.bsu.lab.second.variantb.Main.getN();// number of elements in the array
            StringConsole[] stringConsoles = new StringConsole[number];

            // вводим строки
            for (int i = 0;i < number;i++){
                stringConsoles[i] = new StringConsole();
                stringConsoles[i].inputString();
            }

            StringParser stringParser = new StringParser();

            System.out.printf("Average string length - %f\n", stringParser.averageStringsLength(stringConsoles));
            // получаем строки
            List<StringConsole> lessStrings = stringParser.lessThanAverageLength(stringConsoles);
            List<StringConsole> moreStrings = stringParser.moreThanAverageLength(stringConsoles);

            // вывод
            System.out.println("Strings of less than average length\nСтроки длины которых меньше средней");
            for (StringConsole item:
                    lessStrings) {
                item.displayString();
            }

            System.out.println("Strings longer than the average length\nСтроки длины которых больше средней");
            for (StringConsole item:
                    moreStrings) {
                item.displayString();
            }

            TimeReport.display(2019, 1,19,14,0,0);

        } catch (NumberFormatException e) {
            System.out.println( "Было введено не целое число или не число\n" +
                    "Was entered is not an integer or not a number\n");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
