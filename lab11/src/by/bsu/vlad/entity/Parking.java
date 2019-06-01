package by.bsu.vlad.entity;

import by.bsu.vlad.factory.Factory;
import by.bsu.vlad.factory.ParkingSpaceFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Parking extends Place {
    private Set<ParkingSpace> parkingSpaces;

    public Parking(String name, int capacity) {
        super(name);
        initializeSpaces(capacity);
    }

    public void initializeSpaces(int capacity) {

        Factory<ParkingSpace> factory = new ParkingSpaceFactory();
        parkingSpaces = Collections.synchronizedSet(new HashSet<>(capacity));
        for (int i = 0; i < capacity; i++) {
            parkingSpaces.add(factory.create());
        }
    }

    public Set<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }
}
