package by.bsu.homeapplication.action;

import by.bsu.homeapplication.entity.HomeElectricalApplication;
import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.exception.StorageException;
import by.bsu.homeapplication.init.HomeElectricalApplicationStorageInitializer;
import by.bsu.homeapplication.read.HomeElectricalApplicationReader;
import by.bsu.homeapplication.store.HomeElectricalApplicationStorage;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeElectricalApplicationSorterTest {

    @BeforeAll
    public static void initTest() throws InvalidDataException {
        HomeElectricalApplicationReader reader = new HomeElectricalApplicationReader();
        HomeElectricalApplicationStorageInitializer initializer = new HomeElectricalApplicationStorageInitializer();
        initializer.init(reader.read("data/applications1.txt"));

    }

    @Test
    public void sortByConsuming() throws StorageException {
        HomeElectricalApplicationStorage storage = HomeElectricalApplicationStorage.getInstance();
        HomeElectricalApplicationSorter sorter = new HomeElectricalApplicationSorter();
        sorter.sortByConsuming(storage);
        HomeElectricalApplication application1 = storage.takeHomeElectricalApplication();
        HomeElectricalApplication application2 = storage.takeHomeElectricalApplication();
        assertTrue(application1.getElectricityConsuming() <= application2.getElectricityConsuming());
        while (!storage.isEmpty()) {
            storage.takeHomeElectricalApplication();
        }
    }
}