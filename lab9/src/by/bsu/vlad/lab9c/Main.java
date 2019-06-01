package by.bsu.vlad.lab9c;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**Вариант С
 * При выполнении следующих заданий для вывода результатов создавать но-
 * вую директорию и файл средствами класса File.
 * 3. Прочитать текст Java-программы и записать в другой файл в обратном по-
 * рядке символы каждой строки.
 */

public class Main {
    public static void main(String[] args) {
        FileReader inputFile;
        File outputFile;
        FileWriter fr = null;
        String str;
        try {
            inputFile = new FileReader("/home/vlad/Documents/study/progs/progsJava/lab9/input.txt");
            outputFile = new File("/home/vlad/Documents/study/progs/progsJava/lab9/file1.txt");
            fr = new FileWriter(outputFile);
            Scanner in = new Scanner(inputFile);
            while (in.hasNextLine()) {
                str = in.nextLine();
                char[] p = str.toCharArray();
                for (int i = 0; i < p.length; i++) {
                    fr.write(p[p.length - i - 1]);
                }
                fr.write(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            System.err.println("Exception occurred: " + e.toString());
            //e.printStackTrace();
            System.exit(0);
        } finally {
            try {
                fr.close();
            } catch (IOException e1) {
                System.err.println("Exception occurred: " + e1.toString());
                System.exit(0);
            }
        }
    }
}