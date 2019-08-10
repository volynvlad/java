package by.bsu.homeapplication.read;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class HomeElectricalApplicationReaderTest {

    @Test(expected = RuntimeException.class)
    public void readTest() {
        HomeElectricalApplicationReader reader = new HomeElectricalApplicationReader();
        reader.read("/");
    }

    @Test
    public void readTestSuccess(){
        LinkedList<String> strings1 = new LinkedList<>();
        String str1 = "type=fridge id=1 name=atlant producer=belarus electricalconsuming=200 connected=connected";
        String str2 = "type=router id=2 name=samsung producer=china electricalconsuming=55 connected=connected";
        strings1.add(str1);
        strings1.add(str2);
        HomeElectricalApplicationReader reader = new HomeElectricalApplicationReader();
        LinkedList<String> strings2 = reader.read("data/applications1.txt");
        Assert.assertEquals(strings1,strings2);
    }
}