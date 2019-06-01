package by.bsu.vlad.factory;

import by.bsu.vlad.entity.ParkingSpace;

public class ParkingSpaceFactory implements Factory<ParkingSpace> {

    private static long spaceId;

    public ParkingSpace create() {
        return new ParkingSpace(spaceId++);
    }
}
