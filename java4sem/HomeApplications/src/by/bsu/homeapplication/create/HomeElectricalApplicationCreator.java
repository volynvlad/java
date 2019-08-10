package by.bsu.homeapplication.create;

import by.bsu.homeapplication.entity.*;
import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.parser.HomeElectricalApplicationParser;

public class HomeElectricalApplicationCreator {
    private HomeElectricalApplicationParser homeElectricalApplicationParser;

    public HomeElectricalApplicationCreator(HomeElectricalApplicationParser parser) {
        this.homeElectricalApplicationParser = parser;
    }

    public Fridge createFridge() throws InvalidDataException {
        return new Fridge(
                homeElectricalApplicationParser.takeHomeElectricalApplicationId(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationName(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationProducer(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationConsuming(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationConnected(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationType());
    }

    public Lamp createLamp() throws InvalidDataException {
        return new Lamp(
                homeElectricalApplicationParser.takeHomeElectricalApplicationId(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationName(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationProducer(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationConsuming(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationConnected(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationType());
    }

    public Router createRouter() throws InvalidDataException {
        return new Router(
                homeElectricalApplicationParser.takeHomeElectricalApplicationId(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationName(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationProducer(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationConsuming(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationConnected(),
                homeElectricalApplicationParser.takeHomeElectricalApplicationType());
    }

    public HomeElectricalApplication createHomeElectricalApplication() throws InvalidDataException {
        if (homeElectricalApplicationParser.takeHomeElectricalApplicationType().equals(Type.FRIDGE)) {
            return createFridge();
        } else if (homeElectricalApplicationParser.takeHomeElectricalApplicationType().equals(Type.LAMP)) {
            return createLamp();
        } else if (homeElectricalApplicationParser.takeHomeElectricalApplicationType().equals(Type.ROUTER)) {
            return createRouter();
        } else {
            throw new InvalidDataException("Not valid home electrical application type");
        }
    }
}
