package by.bsu.lab.basic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vlad on 20.02.2019.
 *
 * @version version 1.0
 * @author Volynets V.O.
 */
public class Person {
    private static AtomicInteger    nextId = new AtomicInteger();
    private long                    idPerson;
    protected String                name;
    protected String                surname;
    protected String                nameAfterFather;
    {
        idPerson = nextId.incrementAndGet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, String nameAfterFather) {
        this.name = name;
        this.surname = surname;
        this.nameAfterFather = nameAfterFather;
    }

    public void setNameAfterFather(String nameAfterFather) {
        this.nameAfterFather = nameAfterFather;
    }

    public long getIdPerson() {
        return idPerson;
    }

    public String getNameAfterFather() {
        return nameAfterFather;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
