package by.bsu.lab.second.varianta;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class string
 * Created by vlad on 20.02.2019.
 *
 * @version version 1.0
 * @author Volynets V.O.
 */

public class StringConsole {
    private static AtomicInteger    nextId = new AtomicInteger();
    private long                    idString;
    private String                  string;
    {
        idString = nextId.incrementAndGet();
    }
    public StringConsole() {
        string = "";
    }

    public StringConsole(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public long getLength() {
        return string.length();
    }

    public long getIdString() {
        return idString;
    }

    public void inputString() {
        Scanner scanner = new Scanner(System.in);
        string = scanner.next();
    }

    public void displayString() {
        System.out.printf("id : %d / length : %d / string - " , idString, getLength());
        System.out.println(string);
    }
}
