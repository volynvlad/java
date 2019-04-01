package by.bsu.homeapplication.init;

import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.store.HomeElectricalApplicationStorage;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class HomeElectricalApplicationStorageInitializerTest {

    @Test(expected = InvalidDataException.class)
    public void init() throws InvalidDataException {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("type=QQQ id=1 name=atlant producer=russia electricalconsuming=55 connected=connected");
        HomeElectricalApplicationStorageInitializer haesi = new HomeElectricalApplicationStorageInitializer();
        HomeElectricalApplicationStorage storage = haesi.init(strings);

        int expected = 1;
        int actual = storage.countOfHomeElectricalApplications();
        Assert.assertEquals(expected, actual);
    }
}