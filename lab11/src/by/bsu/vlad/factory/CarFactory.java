package by.bsu.vlad.factory;

import by.bsu.vlad.entity.Car;

public class CarFactory implements Factory<Car> {
    private static long carId;
    public Car create() {
        return new Car(carId++);
    }
}