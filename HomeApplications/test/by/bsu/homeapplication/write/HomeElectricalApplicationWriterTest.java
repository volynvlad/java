package by.bsu.homeapplication.write;

import by.bsu.homeapplication.read.HomeElectricalApplicationReader;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class HomeElectricalApplicationWriterTest {

    @Test
    public void write() {
        HomeElectricalApplicationWriter writer = new HomeElectricalApplicationWriter();
        writer.write("data/applications.txt","data/applications_write_test.txt");
    }
}