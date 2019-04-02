package by.bsu.homeapplication.action;

import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.exception.StorageException;
import by.bsu.homeapplication.init.HomeElectricalApplicationStorageInitializer;
import by.bsu.homeapplication.read.HomeElectricalApplicationReader;
import by.bsu.homeapplication.store.HomeElectricalApplicationStorageConnected;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeElectricalApplicationConnectorTest {

    @BeforeAll
    public static void init() throws InvalidDataException {
        HomeElectricalApplicationReader reader = new HomeElectricalApplicationReader();
        HomeElectricalApplicationStorageInitializer initializer = new HomeElectricalApplicationStorageInitializer();
        initializer.init(reader.read("data/applications.txt"));
    }

    @Test
    public void connected() throws StorageException {
        HomeElectricalApplicationConnector connector = new HomeElectricalApplicationConnector();
        HomeElectricalApplicationStorageConnected connected = connector.connected();
        int expected = 6;
        int result = connected.countOfHomeElectricalApplications();

        assertEquals(expected, result);

    }
}