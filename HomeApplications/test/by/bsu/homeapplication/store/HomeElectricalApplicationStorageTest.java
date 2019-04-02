package by.bsu.homeapplication.store;

import by.bsu.homeapplication.action.HomeElectricalApplicationSorter;
import by.bsu.homeapplication.entity.HomeElectricalApplication;
import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.init.HomeElectricalApplicationStorageInitializer;
import by.bsu.homeapplication.parser.HomeElectricalApplicationParser;
import by.bsu.homeapplication.read.HomeElectricalApplicationReader;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class HomeElectricalApplicationStorageTest {

    @BeforeAll
    public static void init() throws InvalidDataException{
        HomeElectricalApplicationReader reader = new HomeElectricalApplicationReader();
        HomeElectricalApplicationStorageInitializer initializer = new HomeElectricalApplicationStorageInitializer();
        initializer.init(reader.read("data/applications.txt"));

    }

    @Test
    public void countOfHomeElectricalApplications() {
        HomeElectricalApplicationStorage storage = HomeElectricalApplicationStorage.getInstance();
        int expected = 17;
        int result = storage.countOfHomeElectricalApplications();

        assertEquals(expected, result);

    }

    @Test
    public void isEmpty(){
        HomeElectricalApplicationStorage storage = HomeElectricalApplicationStorage.getInstance();
        assertFalse(storage.isEmpty());
    }
}