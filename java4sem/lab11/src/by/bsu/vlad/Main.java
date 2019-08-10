package by.bsu.vlad;

import by.bsu.vlad.entity.Car;
import by.bsu.vlad.entity.Parking;
import by.bsu.vlad.factory.CarFactory;
import by.bsu.vlad.factory.Factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static by.bsu.vlad.util.ApplicationProperties.CAPACITY;
import static by.bsu.vlad.util.ApplicationProperties.CAR_AMOUNT;

/**
 * Разработать многопоточное приложение.
 * Все сущности, желающие получить доступ к ресурсу, должны быть
 * потоками. Использовать возможности ООП.
 *
 * 3. Автостоянка. Доступно несколько машиномест. На одном месте
 * может находиться только один автомобиль. Если все места заняты,
 * то автомобиль не станет ждать больше определенного времени и
 * уедет на другую стоянку.
 *
 */
public class Main {

    public static void main(String args[]) {

        Parking parking = new Parking("Local parking", CAPACITY);
        ExecutorService executorService = Executors.newFixedThreadPool(CAR_AMOUNT);
        Factory<Car> factory = new CarFactory();

        for (int i = 0; i < CAR_AMOUNT; i++) {
            Car car = factory.create();
            car.setParking(parking);
            executorService.execute(car);
        }

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();

    }

}
