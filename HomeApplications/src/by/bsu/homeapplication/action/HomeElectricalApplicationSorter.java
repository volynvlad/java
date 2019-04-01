package by.bsu.homeapplication.action;

import by.bsu.homeapplication.compare.ConsumingHomeElectricalApplicationComparator;
import by.bsu.homeapplication.entity.HomeElectricalApplication;
import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.store.HomeElectricalApplicationStorage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.LinkedList;

public class HomeElectricalApplicationSorter {
    private static final Logger LOGGER = LogManager.getLogger(HomeElectricalApplicationSorter.class);

    /*public void sortByConsuming(HomeElectricalApplicationStorage storage) {
        LinkedList<HomeElectricalApplication> applications = storage.getApps();
        Collections.sort(applications, new ConsumingHomeElectricalApplicationComparator().thenComparing(new ConsumingHomeElectricalApplicationComparator()));
        try {
            storage.setApps(applications);
        } catch (InvalidDataException e) {
            LOGGER.log(Level.ERROR, "Problem with set home electrical applications to summer", e);
        }
    }*/
}
