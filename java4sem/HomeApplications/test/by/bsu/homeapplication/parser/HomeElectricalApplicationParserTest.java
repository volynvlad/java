package by.bsu.homeapplication.parser;

import by.bsu.homeapplication.exception.InvalidDataException;
import org.junit.Assert;
import org.junit.Test;

public class HomeElectricalApplicationParserTest {

    @Test
    public void parseTest() throws InvalidDataException {
        HomeElectricalApplicationParser parser =
                new HomeElectricalApplicationParser
                        ("type=fridge id=1 name=atlant producer=belarus electricalconsuming=200 connected=connected");
        Assert.assertTrue(parser.takeHomeElectricalApplicationProducer().toString().equals("BELARUS"));
        Assert.assertTrue(parser.takeHomeElectricalApplicationConnected().equals("CONNECTED"));
        Assert.assertTrue(parser.takeHomeElectricalApplicationName().equals("ATLANT"));
        Assert.assertEquals(parser.takeHomeElectricalApplicationConsuming(), 200,0.01);
        Assert.assertEquals(parser.takeHomeElectricalApplicationId(), 1);
    }

    @Test(expected = InvalidDataException.class)
    public void parseTest1() throws InvalidDataException {
        HomeElectricalApplicationParser parser = new HomeElectricalApplicationParser("type=fridgee id=1 name=atlant producer=belarus electricalconsuming=200 connected=connected");
        Assert.assertTrue(parser.takeHomeElectricalApplicationType().toString().equals("FRIDGE"));
    }

    @Test(expected = InvalidDataException.class)
    public void parseTest2() throws InvalidDataException {
        HomeElectricalApplicationParser parser = new HomeElectricalApplicationParser("type=fridgee id=1 name=atlant producer=belarus electricalconsuming=200 connected=connected");
        Assert.assertTrue(parser.takeHomeElectricalApplicationType().toString().equals("FRIDGEE"));
    }
}