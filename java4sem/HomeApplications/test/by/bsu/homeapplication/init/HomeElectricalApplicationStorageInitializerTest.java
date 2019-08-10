package by.bsu.homeapplication.init;

import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.exception.StorageException;
import by.bsu.homeapplication.store.HomeElectricalApplicationStorage;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class HomeElectricalApplicationStorageInitializerTest {

    @Test(expected = InvalidDataException.class)
    public void init() throws InvalidDataException, StorageException {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("type=QQQ id=1 name=atlant producer=russia electricalconsuming=55 connected=connected");
        HomeElectricalApplicationStorageInitializer initializer = new HomeElectricalApplicationStorageInitializer();
        HomeElectricalApplicationStorage storage = initializer.init(strings);

        int expected = 1;
        int actual = storage.countOfHomeElectricalApplications();
        while(!storage.isEmpty()) {
            storage.takeHomeElectricalApplication();
        }
        Assert.assertEquals(expected, actual);
    }
}