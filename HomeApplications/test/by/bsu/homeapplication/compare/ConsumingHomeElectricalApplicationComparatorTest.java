package by.bsu.homeapplication.compare;

import by.bsu.homeapplication.create.HomeElectricalApplicationCreator;
import by.bsu.homeapplication.entity.HomeElectricalApplication;
import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.parser.HomeElectricalApplicationParser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class ConsumingHomeElectricalApplicationComparatorTest {

    @Test
    public void compare() throws InvalidDataException {
        LinkedList<String> strings = new LinkedList<>();
        String str1 = "type=fridge id=1 name=atlant producer=belarus electricalconsuming=200 connected=connected";
        String str2 = "type=router id=2 name=samsung producer=china electricalconsuming=55 connected=connected";
        strings.add(str1);
        strings.add(str2);
        ConsumingHomeElectricalApplicationComparator comparator = new ConsumingHomeElectricalApplicationComparator();

        HomeElectricalApplicationParser parser1 = new HomeElectricalApplicationParser(str1);
        HomeElectricalApplicationParser parser2 = new HomeElectricalApplicationParser(str2);

        HomeElectricalApplicationCreator creator1 = new HomeElectricalApplicationCreator(parser1);
        HomeElectricalApplicationCreator creator2 = new HomeElectricalApplicationCreator(parser2);

        HomeElectricalApplication application1 = creator1.createHomeElectricalApplication();
        HomeElectricalApplication application2 = creator2.createHomeElectricalApplication();

        int result = comparator.compare(application1, application2);
        int expected = 1;

        Assert.assertEquals(result, expected);
    }
}