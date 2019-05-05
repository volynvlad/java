package by.bsu.homeapplication.read;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeElectricalApplicationReader {
    private static final Logger LOGGER = LogManager.getLogger(HomeElectricalApplicationReader.class);

    public LinkedList<String> read(String path) {
        LinkedList<String> strings = new LinkedList<>();
        try {
            Stream<String> lines = Files.lines(Paths.get(path));
            strings = lines.collect(Collectors.toCollection(LinkedList::new));

        } catch (IOException e) {
            LOGGER.log(Level.FATAL, e);
            e.printStackTrace();
        }
        return strings;
    }
}
