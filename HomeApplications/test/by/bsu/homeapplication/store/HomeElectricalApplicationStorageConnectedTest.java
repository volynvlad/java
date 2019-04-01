package by.bsu.homeapplication.store;

import by.bsu.homeapplication.action.HomeElectricalApplicationConnector;
import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.exception.StorageException;
import by.bsu.homeapplication.init.HomeElectricalApplicationStorageInitializer;
import by.bsu.homeapplication.read.HomeElectricalApplicationReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeElectricalApplicationStorageConnectedTest {


    @BeforeAll
    public static void init() throws InvalidDataException {
        HomeElectricalApplicationReader reader = new HomeElectricalApplicationReader();
        HomeElectricalApplicationStorageInitializer initializer = new HomeElectricalApplicationStorageInitializer();
        initializer.init(reader.read("data/applications.txt"));

    }

    @Test
    public void countOfHomeElectricalApplications() throws StorageException {
        HomeElectricalApplicationConnector connector = new HomeElectricalApplicationConnector();
        HomeElectricalApplicationStorageConnected storage = connector.connected();

        int expected = 1;
        int result = storage.countOfHomeElectricalApplications();

        assertEquals(expected, result);

    }

    @Test
    public void isEmpty() throws StorageException {
        HomeElectricalApplicationConnector connector = new HomeElectricalApplicationConnector();
        HomeElectricalApplicationStorageConnected storage = connector.connected();
        assertFalse(storage.isEmpty());
    }
}