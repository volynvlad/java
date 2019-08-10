package by.bsu.vlad.lab9a;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**Вариант А
 * В следующих заданиях требуется ввести последовательность строк из текс-
 тового потока и выполнить указанные действия. При этом могут рассматри-
 ваться два варианта:
 • каждая строка состоит из одного слова;
 • каждая строка состоит из нескольких слов.
 Имена входного и выходного файлов, а также абсолютный путь к ним
 3. В каждой строке найти слова, начинающиеся с гласной буквы.
 */

public class Main {
    public static void main(String[] args) {

        FileReader myfile = null;
        File file;
        FileWriter fileWriter = null;
        String str;

        try {
            myfile = new FileReader("/home/vlad/Documents/study/progs/progsJava/lab9/myfile.txt");
            file = new File("/home/vlad/Documents/study/progs/progsJava/lab9/file.txt");
            fileWriter = new FileWriter(file);
            Scanner scanner = new Scanner(myfile);
            char []vowel = new char[6];
            vowel[0] = 'a';
            vowel[1] = 'e';
            vowel[2] = 'i';
            vowel[3] = 'o';
            vowel[4] = 'u';
            vowel[5] = 'y';
            while(scanner.hasNextLine()) {
                str = scanner.nextLine();
                String []p = str.split(" ");
                for(int i = 0; i < p.length; i++) {
                    char k = p[i].charAt(0);
                    for(int j = 0; j < vowel.length; j++) {
                        if(k == vowel[j]) {
                            fileWriter.write(p[i]+" ");
                            fileWriter.write(System.getProperty("line.separator"));
                        }
                    }
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.close();
                myfile.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
