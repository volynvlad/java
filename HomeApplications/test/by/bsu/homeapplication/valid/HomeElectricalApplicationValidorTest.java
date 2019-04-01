package by.bsu.homeapplication.valid;

import org.junit.Test;
import org.junit.Assert;


public class HomeElectricalApplicationValidorTest {

    @Test
    public void isValidHomeElectricalApplicationTest() {
        String testStr = "type=fridge id=1 name=samsung producer=china electricalconsuming=200 connected=connected";
        Assert.assertTrue(HomeElectricalApplicationValidor.isValidHomeElectricalApplication(testStr));
    }

    @Test
    public void isValidHomeElectricalApplicationTest1() {
        Assert.assertTrue(HomeElectricalApplicationValidor.isValidProducer("russia"));
        Assert.assertFalse(HomeElectricalApplicationValidor.isValidProducer("rusia"));
    }
}