package by.bsu.homeapplication.init;

import by.bsu.homeapplication.create.HomeElectricalApplicationCreator;
import by.bsu.homeapplication.entity.Type;
import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.parser.HomeElectricalApplicationParser;
import by.bsu.homeapplication.store.HomeElectricalApplicationStorage;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

public class HomeElectricalApplicationStorageInitializer {
    private static final Logger LOGGER = LogManager.getLogger(HomeElectricalApplicationStorageInitializer.class);

    public HomeElectricalApplicationStorage init(LinkedList<String> strings) throws InvalidDataException {
        HomeElectricalApplicationStorage storage = HomeElectricalApplicationStorage.getInstance();
        HomeElectricalApplicationParser homeElectricalApplicationParser;
        HomeElectricalApplicationCreator homeElectricalApplicationCreator;
        Type type;

        while(!strings.isEmpty()){
            homeElectricalApplicationParser = new HomeElectricalApplicationParser(strings.removeFirst());
            homeElectricalApplicationCreator = new HomeElectricalApplicationCreator(homeElectricalApplicationParser);
            try {
                type = homeElectricalApplicationParser.takeHomeElectricalApplicationType();
                switch (type){
                    case FRIDGE:
                        storage.addHomeElectricalApplication(homeElectricalApplicationCreator.createFridge());
                        break;
                    case LAMP:
                        storage.addHomeElectricalApplication(homeElectricalApplicationCreator.createLamp());
                        break;
                    case ROUTER: {
                        storage.addHomeElectricalApplication(homeElectricalApplicationCreator.createRouter());
                        break;
                    }
                    default:
                        throw new InvalidDataException("There is no such home electrical application");
                }
            } catch (InvalidDataException e) {
                LOGGER.log(Level.ERROR, "String contain not valid home electrical application", e);
                throw new InvalidDataException("There is no such home electrical application");
            }
        }
        return storage;
    }
}
