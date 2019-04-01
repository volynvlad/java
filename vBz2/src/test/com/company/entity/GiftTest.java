package test.com.company.entity;

import com.company.gift.entity.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by HP on 09.01.2017.
 */
public class GiftTest {
    @Test
    public void setSweets() throws Exception {
        Sweet sweet1 = new GlazedCandy(1,"Alenka", Producer.BELARUS, 0.5, 30, Taste.SUGARY, Frosting.CHOCOLATE);
        Sweet sweet2 = new GlazedCandy(1,"Mischka", Producer.BELARUS, 0.9, 65, Taste.SUGARY, Frosting.CHOCOLATE);
        LinkedList<Sweet> sweets1=new LinkedList<>();
        sweets1.add(sweet1);
        sweets1.add(sweet2);
        LinkedList<Sweet> sweets2=new LinkedList<>();
        sweets2.add(sweet2);
        sweets2.add(sweet1);

        LinkedList<Sweet> expected = sweets2;
        Gift gift = new Gift(sweets1);
        gift.setSweets(sweets2);
        LinkedList<Sweet> actual  = gift.getSweets();
        Assert.assertEquals(expected,actual);
    }

}