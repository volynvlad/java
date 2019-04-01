package test.com.company.init;

import com.company.gift.exception.InvalidDataException;
import com.company.gift.init.SweetStorageInitializer;
import com.company.gift.store.SweetStorage;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by HP on 10.01.2017.
 */
public class SweetStorageInitializerTest {
    @Test(expected = InvalidDataException.class)
    public void init() throws InvalidDataException {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("type=QQQ id=1 name=alenka weight=25 sugar=15 producer=russia taste=sugary frosting=milk");
        SweetStorageInitializer ssi= new SweetStorageInitializer();
        SweetStorage storage = ssi.init(strings);

        int expected = 1;
        int actual = storage.countOfSweets();
        Assert.assertEquals(expected, actual);
    }

}