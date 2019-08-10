package by.bsu.lab.first;

import by.bsu.lab.basic.TimeReport;

import java.io.IOException;
import java.util.Scanner;

/**
 * Input integer number and Random
 * Output numbers which divided by 3 and 9
 *
 * Created by vlad on 19.02.2019
 *
 * @version 1.0.0
 * @author  Volynets V.O.
 */

public class Main {
    /**
     * Задание к Главе 1
     * Вариант B
     * 3. Числа, которые делятся на 3 или на 9.
     */
    public static void main(String[] args) {
        try {
            int size; // number of elements in the array
            int cntDivBy3 = 0; // counter of numbers divided by 3
            int cntDivBy9 = 0; // counter of numbers divided by 9

            System.out.println( "Введите количество требуемых чисел и нажмите <Enter>\n" +
                    "Enter the required number of numbers and press <Enter>");
            size = getSize();

            System.out.printf("size = %d\n", size);
            DividerFactory dividerFactory = new DividerFactory();

            // Генерация делителей
            Divider[] divider = dividerFactory.generateDividers(size);

            for (int i = 0; i < size; i++) {
                if(divider[i].isDivBy3()) {
                    System.out.printf("id:%d\t %d делится на (is divided by) 3\n",
                            divider[i].getIdDivider(), divider[i].getNumber());
                    cntDivBy3++;
                }
            }

            System.out.println("=============================");
            System.out.printf(  "The number of numbers divisible by 3: %d\n" +
                    "Количество чисел делящихся на 3: %d\n",cntDivBy3, cntDivBy3);
            System.out.println("=============================");
            for (int i = 0; i < size; i++) {
                if(divider[i].isDivBy9()) {
                    System.out.printf("id:%d\t %d делится на (is divided by) 9\n",
                            divider[i].getIdDivider(), divider[i].getNumber());
                    cntDivBy9++;
                }
            }
            System.out.println("=============================");
            System.out.printf(  "The number of numbers divisible by 9: %d\n" +
                    "Количество чисел делящихся на 9: %d\n",cntDivBy9, cntDivBy9);

            TimeReport.display(2019, 1,16,10,0,0);

        } catch (NumberFormatException e) {
            System.out.println( "Было введено не целое число или не число\n" +
                    "Was entered is not an integer or not a number\n");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int getSize() throws IOException {
        int size;
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        size = Integer.parseInt(string);

        if (size <= 0) {
            throw new IOException(  "Количество чисел должно быть положительным\n" +
                    "Number of numbers should be positive\n");
        }
        return size;
    }
}
