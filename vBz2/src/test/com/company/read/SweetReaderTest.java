package test.com.company.read;

import com.company.gift.read.SweetReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class SweetReaderTest {
    @Test(expected = RuntimeException.class)
    public void readTest(){
        SweetReader sweetReader = new SweetReader();
        sweetReader.read("/");
    }

    @Test
    public void readTestSucsess(){
        LinkedList<String> strings1 = new LinkedList<>();
        String str1 = "type=Glazed_Candy id=1 name=alenka weight=25 sugar=15 producer=russia taste=sugary frosting=milk";
        String str2 = "type=Lollipop id=2 name=petya weight=78 sugar=46 producer=poland form=DISK taste=sugary";
        strings1.add(str1);
        strings1.add(str2);
        SweetReader sweetReader = new SweetReader();
        LinkedList<String> strings2 = sweetReader.read("data/sweets1.txt");
        Assert.assertEquals(strings1,strings2);
    }

}
