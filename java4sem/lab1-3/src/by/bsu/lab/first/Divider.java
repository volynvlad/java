package by.bsu.lab.first;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class diveder
 * Created by vlad on 19.02.2019
 * @version version 1.0
 * @author Volynets V.O.
 */

public class Divider {
    private static      AtomicInteger nextId = new AtomicInteger();
    private long        idDivider;
    private int         number;

    {
        this.idDivider = nextId.incrementAndGet();
    }
    public Divider() {
        this.number = 10;
    }

    public Divider(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getIdDivider() {
        return idDivider;
    }

    public boolean isDivBy3() {
        return number % 3 == 0;
    }
    public boolean isDivBy9() {
        return number % 9 == 0;
    }
}
