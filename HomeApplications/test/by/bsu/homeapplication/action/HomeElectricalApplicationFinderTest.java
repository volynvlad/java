package by.bsu.homeapplication.action;

import by.bsu.homeapplication.exception.IncorrectValueException;
import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.exception.StorageException;
import by.bsu.homeapplication.init.HomeElectricalApplicationStorageInitializer;
import by.bsu.homeapplication.read.HomeElectricalApplicationReader;
import by.bsu.homeapplication.store.HomeElectricalApplicationStorage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeElectricalApplicationFinderTest {

    @BeforeClass
    public static void initTest() throws InvalidDataException {
        HomeElectricalApplicationReader reader = new HomeElectricalApplicationReader();
        HomeElectricalApplicationStorageInitializer initializer = new HomeElectricalApplicationStorageInitializer();
        initializer.init(reader.read("data/applications.txt"));
        HomeElectricalApplicationStorage storage = HomeElectricalApplicationStorage.getInstance();
    }

    @Test
    public void sortByConsuming() throws StorageException, IncorrectValueException {
        double expected = 50;
        double actual = new HomeElectricalApplicationFinder().findByConsuming(new HomeElectricalApplicationConnector().connect(5),49, 51).getFirst().getElectricityConsuming();
        Assert.assertEquals(expected, actual, 0.01);
    }
}