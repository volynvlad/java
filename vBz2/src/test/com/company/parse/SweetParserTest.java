package test.com.company.parse;

import com.company.gift.exception.InvalidDataException;
import com.company.gift.parse.SweetParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class SweetParserTest {
    @Test
    public void parseTest() throws InvalidDataException {
        SweetParser sweetParser = new SweetParser("type=Glazed_Candy id=1 name=alenka weight=25 sugar=15 producer=russia taste=sugary frosting=milk");
        Assert.assertTrue(sweetParser.takeSweetType().toString().equals("GLAZED_CANDY"));
        Assert.assertTrue(sweetParser.takeSweetName().toString().equals("ALENKA"));
        Assert.assertTrue(sweetParser.takeSweetTaste().toString().equals("SUGARY"));
        Assert.assertEquals(sweetParser.takeSweetWeight(), 25, 0.01);
        Assert.assertEquals(sweetParser.takeSweetSugar(), 15, 0.01);
        Assert.assertTrue(sweetParser.takeSweetProducer().toString().equals("RUSSIA"));
        Assert.assertTrue(sweetParser.takeSweetFrosting().toString().equals("MILK"));
        Assert.assertEquals(sweetParser.takeSweetId(), 1);
        LinkedList list = new LinkedList();
    }

    @Test(expected = InvalidDataException.class)
    public void parseTest1() throws InvalidDataException {
        SweetParser sweetParser = new SweetParser("type=GlazedCandy id=1 name=alenka weight=25 sugar=15 producer=russia taste=sugary frosting=milk");
        Assert.assertTrue(sweetParser.takeSweetType().toString().equals("GLAZED_CANDY"));
    }

    @Test(expected = InvalidDataException.class)
    public void parseTest2() throws InvalidDataException {
        SweetParser sweetParser = new SweetParser("type=Glazed_Candy id=1 name=alenka weght=25 sugar=15 producer=russia taste=sugary frosting=milk");
        Assert.assertTrue(sweetParser.takeSweetType().toString().equals("GLAZED_CANDY"));
    }
}
