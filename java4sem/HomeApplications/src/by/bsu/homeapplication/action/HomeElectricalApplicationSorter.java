package by.bsu.homeapplication.action;

import by.bsu.homeapplication.compare.ConsumingHomeElectricalApplicationComparator;
import by.bsu.homeapplication.entity.HomeElectricalApplication;
import by.bsu.homeapplication.store.HomeElectricalApplicationStorage;

import java.util.Collections;
import java.util.LinkedList;

public class HomeElectricalApplicationSorter {
    public void sortByConsuming(HomeElectricalApplicationStorage storage) {
        LinkedList<HomeElectricalApplication> applications = storage.getHomeElectricalApplications();
        Collections.sort(applications, new ConsumingHomeElectricalApplicationComparator().thenComparing(new ConsumingHomeElectricalApplicationComparator()));
        storage.setHomeElectricalApplications(applications);
    }
}
