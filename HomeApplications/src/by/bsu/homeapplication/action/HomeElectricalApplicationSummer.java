package by.bsu.homeapplication.action;

import by.bsu.homeapplication.entity.HomeElectricalApplication;
import by.bsu.homeapplication.exception.InvalidDataException;

import java.util.LinkedList;

public class HomeElectricalApplicationSummer {
    private double totalConsuming;
    LinkedList<HomeElectricalApplication> apps = new LinkedList<HomeElectricalApplication>();

    public void connect(HomeElectricalApplication h) {
        if (h.getConnected().equals("CONNECTED")) {
            apps.add(h);
            totalConsuming += h.getElectricityConsuming();
        }
    }

    public void disconnect(HomeElectricalApplication h) {
        if (h.getConnected().equals("DISCONNECTED")) {
            apps.add(h);
            totalConsuming -= h.getElectricityConsuming();
        }
    }

    public void setApps(LinkedList<HomeElectricalApplication> applications) throws InvalidDataException {
        if (this.apps.containsAll(applications) && applications.containsAll(this.apps)){
            this.apps = applications;
        }
    }

    public LinkedList<HomeElectricalApplication> getApps() {
        return this.apps;
    }

    public double getTotalConsuming() {
        return totalConsuming;
    }
}
