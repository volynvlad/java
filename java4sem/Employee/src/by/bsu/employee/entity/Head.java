package by.bsu.employee.entity;

import java.util.concurrent.atomic.AtomicInteger;

// руководитель
public class Head extends Engineer {
    private static final String name = "Head";
    private long idHead;
    private static AtomicInteger nextId = new AtomicInteger();

    {
        idHead = nextId.incrementAndGet();
    }
    public void doingWork() {
        System.out.println(name + "id: " + idEmployee() + " doing work");
    }

    public void giveTaskToEngineer(String taskName) {
        System.out.println(name + " give task " + taskName);
    }

    public long idEmployee() {
        return idHead;
    }
}
