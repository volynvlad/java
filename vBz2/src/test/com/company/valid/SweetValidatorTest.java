package test.com.company.valid;

import com.company.gift.valid.SweetValidator;
import org.junit.Assert;
import org.junit.Test;

public class SweetValidatorTest {
    @Test
    public void isValidSweetTest(){
        String testStr = "type=Glazed_Candy id=1 name=alenka weight=25 sugar=15 producer=russia taste=sugary frosting=milk";
        Assert.assertTrue(SweetValidator.isValidSweet(testStr));
        Assert.assertTrue(SweetValidator.isValidCandy(testStr));
        Assert.assertTrue(SweetValidator.isValidGlazedCandy(testStr));
        Assert.assertFalse(SweetValidator.isValidLollipop(testStr));
        Assert.assertFalse(SweetValidator.isValidWafer(testStr));
    }

    @Test
    public void isValidSweetTest1(){
        Assert.assertTrue(SweetValidator.isValidSweetType("Lollipop"));
        Assert.assertFalse(SweetValidator.isValidSweetType("Lollpop"));
        Assert.assertTrue(SweetValidator.isValidForm("disk"));
        Assert.assertFalse(SweetValidator.isValidForm("dsk"));
        Assert.assertTrue(SweetValidator.isValidAroma("cola"));
        Assert.assertTrue(SweetValidator.isValidFrosting("milk"));
        Assert.assertTrue(SweetValidator.isValidTaste("sour"));
        Assert.assertTrue(SweetValidator.isValidProducer("russia"));
    }
}
