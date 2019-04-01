package by.bsu.homeapplication.store;

import by.bsu.homeapplication.entity.HomeElectricalApplication;
import by.bsu.homeapplication.exception.StorageException;

import java.util.LinkedList;

public class HomeElectricalApplicationStorageConnected {
    private LinkedList<HomeElectricalApplication> homeElectricalApplications;
    private static final HomeElectricalApplicationStorageConnected INSTANCE = new HomeElectricalApplicationStorageConnected();

    private HomeElectricalApplicationStorageConnected() {
        this.homeElectricalApplications = new LinkedList<>();
    }

    public static HomeElectricalApplicationStorageConnected getInstance() {
        return INSTANCE;
    }

    public void addHomeElectricalApplication(HomeElectricalApplication h) {
        if (h.getConnected().equals("CONNECTED")) {
            homeElectricalApplications.addLast(h);
        }
    }

    public HomeElectricalApplication takeHomeElectricalApplication() throws StorageException {
        if(!homeElectricalApplications.isEmpty()) {
            return homeElectricalApplications.removeFirst();
        } else {
            throw new StorageException("HomeElectricalApplicationStorage is empty");
        }
    }

    public int countOfHomeElectricalApplications() {
        return this.homeElectricalApplications.size();
    }

    public boolean isEmpty() {
        return homeElectricalApplications.isEmpty();
    }
}
