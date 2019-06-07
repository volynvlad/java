package by.bsu.lecture.first;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static AtomicInteger nextId = new AtomicInteger();
    private long userId;
    private String name;
    private Role role;
    {
        userId = nextId.incrementAndGet();
    }
}
