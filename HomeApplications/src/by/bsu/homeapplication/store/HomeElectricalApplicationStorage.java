package by.bsu.homeapplication.store;

import by.bsu.homeapplication.entity.HomeElectricalApplication;
import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.exception.StorageException;

import java.util.LinkedList;

public class HomeElectricalApplicationStorage {
    private LinkedList<HomeElectricalApplication> homeElectricalApplications;
    private static final HomeElectricalApplicationStorage INSTANCE = new HomeElectricalApplicationStorage();

    private HomeElectricalApplicationStorage() {
        this.homeElectricalApplications = new LinkedList<>();
    }

    public static HomeElectricalApplicationStorage getInstance() {
        return INSTANCE;
    }

    public void addHomeElectricalApplication(HomeElectricalApplication h) {
        homeElectricalApplications.addLast(h);
    }

    public void removeHomeElectricalApplication(HomeElectricalApplication h) {
        homeElectricalApplications.remove(h);
    }

    public HomeElectricalApplication takeHomeElectricalApplication() throws StorageException {
        if(!homeElectricalApplications.isEmpty()) {
            return homeElectricalApplications.removeFirst();
        } else {
            throw new StorageException("HomeElectricalApplicationStorage is empty");
        }
    }

    public LinkedList<HomeElectricalApplication> getHomeElectricalApplications() {
        return homeElectricalApplications;
    }

    public int countOfHomeElectricalApplications() {
        return this.homeElectricalApplications.size();
    }

    public boolean isEmpty() {
        return homeElectricalApplications.isEmpty();
    }

}
