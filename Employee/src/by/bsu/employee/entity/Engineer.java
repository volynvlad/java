package by.bsu.employee.entity;

import java.util.concurrent.atomic.AtomicInteger;

// инженер
public class Engineer implements Employee {
    private static final String name = "Engineer";
    private static AtomicInteger nextId = new AtomicInteger();
    private long idEngineer;

    {
        idEngineer = nextId.incrementAndGet();
    }

    public void doingWork() {
        System.out.println(name + "id: " + idEmployee() + " doing work");
    }

    public long idEmployee() {
        return idEngineer;
    }
}
