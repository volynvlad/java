package by.bsu.account.reader;

import by.bsu.account.exception.InvalidFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class OperationReader {
    private static final Logger LOGGER = LogManager.getLogger(OperationReader.class);

    public LinkedList<String> readTxt(String path) throws InvalidFileException {
        if (path == null) {
            throw new InvalidFileException("File name can't be null");
        }

        File file = new File(path);
        LinkedList<String> strings = new LinkedList<>();

        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
            return strings;
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.FATAL, e);
            throw new InvalidFileException("No such file: \"" + path + "\"", e);
        }
    }
}
