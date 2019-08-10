package by.bsu.homeapplication.write;

import by.bsu.homeapplication.read.HomeElectricalApplicationReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.LinkedList;


public class HomeElectricalApplicationWriter {
    private static final Logger LOGGER = LogManager.getLogger(HomeElectricalApplicationReader.class);

    public void write(String path1, String path2) {

        try {
            File file1 = new File(path1);
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file1), "UTF8"));
            File file2 = new File(path2);
            FileWriter fw = new FileWriter(file2);

            String string;
            while ((string = in.readLine())!= null) {
                StringBuilder stringBuilder = new StringBuilder(string);
                stringBuilder.setCharAt(0, Character.toUpperCase(string.charAt(0)));
                fw.write(stringBuilder.toString() + "\n");
            }

            fw.close();
            in.close();

        } catch (IOException e) {
            LOGGER.log(Level.FATAL, e);
            e.printStackTrace();
        }
    }
}
