package by.bsu.homeapplication.action;

import by.bsu.homeapplication.entity.HomeElectricalApplication;
import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.exception.StorageException;
import by.bsu.homeapplication.init.HomeElectricalApplicationStorageInitializer;
import by.bsu.homeapplication.read.HomeElectricalApplicationReader;
import by.bsu.homeapplication.store.HomeElectricalApplicationStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeElectricalApplicationSummerTest {

    @BeforeAll
    public static void init() throws InvalidDataException {
        HomeElectricalApplicationReader reader = new HomeElectricalApplicationReader();
        HomeElectricalApplicationStorageInitializer initializer = new HomeElectricalApplicationStorageInitializer();
        initializer.init(reader.read("data/applications.txt"));
    }


    @Test
    public void setApps() throws StorageException {
        HomeElectricalApplicationStorage storage = HomeElectricalApplicationStorage.getInstance();
        HomeElectricalApplication[] applications = new HomeElectricalApplication[storage.countOfHomeElectricalApplications()];
        double result = 0;
        HomeElectricalApplicationSummer summer = new HomeElectricalApplicationSummer();
        for (int i = 0;i < storage.countOfHomeElectricalApplications();i++) {
            applications[i] = storage.takeHomeElectricalApplication();
        }
        System.out.println(storage.countOfHomeElectricalApplications());
        for(HomeElectricalApplication application : applications) {
            summer.connect(application);
        }

        double expected1 = 255;
        double result1 = summer.getTotalConsuming();

        assertEquals(expected1, result1);

    }
}