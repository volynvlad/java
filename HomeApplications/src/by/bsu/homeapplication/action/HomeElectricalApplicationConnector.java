package by.bsu.homeapplication.action;

import by.bsu.homeapplication.exception.StorageException;
import by.bsu.homeapplication.store.HomeElectricalApplicationStorage;
import by.bsu.homeapplication.store.HomeElectricalApplicationStorageConnected;

public class HomeElectricalApplicationConnector {
    public HomeElectricalApplicationSummer connect(int countOfApps) throws StorageException {
        HomeElectricalApplicationStorage storage = HomeElectricalApplicationStorage.getInstance();
        HomeElectricalApplicationSummer summer = new HomeElectricalApplicationSummer();
        if (storage.countOfHomeElectricalApplications() >= countOfApps) {
            for(int i = 0;i < countOfApps; i++) {
                summer.connect(storage.takeHomeElectricalApplication());
            }
            return summer;
        } else {
            throw new StorageException("Storage do not have enough home electrical applications");
        }
    }

    public HomeElectricalApplicationStorageConnected connected() throws StorageException {
        HomeElectricalApplicationStorageConnected storageConnected = HomeElectricalApplicationStorageConnected.getInstance();
        HomeElectricalApplicationStorage storage = HomeElectricalApplicationStorage.getInstance();
        for(int i = 0;i < storage.countOfHomeElectricalApplications(); i++) {
            if (storage.getHomeElectricalApplications().getFirst().getConnected().equalsIgnoreCase("connected")) {
                storageConnected.addHomeElectricalApplication(storage.takeHomeElectricalApplication());
            }
        }
        return storageConnected;
    }
}
