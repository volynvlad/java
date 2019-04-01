package test.com.company.action;

import com.company.gift.action.GiftMaker;
import com.company.gift.action.SweetFinder;
import com.company.gift.exception.IncorrectValueException;
import com.company.gift.exception.InvalidDataException;
import com.company.gift.exception.StorageException;
import com.company.gift.exception.UnknownSweetException;
import com.company.gift.init.SweetStorageInitializer;
import com.company.gift.read.SweetReader;
import com.company.gift.store.SweetStorage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SweetFinderTest {
    @BeforeClass
    public static void initTest() throws InvalidDataException {
        SweetReader sr = new SweetReader();
        SweetStorageInitializer sweetStorageInitializer = new SweetStorageInitializer();
        sweetStorageInitializer.init(sr.read("data\\sweets.txt"));
    }

    @Test
    public void findBySugarTest() throws StorageException, IncorrectValueException {
        SweetStorage storage = SweetStorage.getInstance();
        double expected = 15;
        double actual = new SweetFinder().findBySugar(new GiftMaker().make(8), 14, 16).getFirst().getAmountOfSugar();
        Assert.assertEquals(expected, actual, 0.01);
    }
}
