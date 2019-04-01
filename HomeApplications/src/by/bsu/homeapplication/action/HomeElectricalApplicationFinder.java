package by.bsu.homeapplication.action;

import by.bsu.homeapplication.entity.HomeElectricalApplication;
import by.bsu.homeapplication.exception.IncorrectValueException;

import java.util.LinkedList;
import java.util.List;

public class HomeElectricalApplicationFinder {
    public LinkedList<HomeElectricalApplication> findByConsuming(HomeElectricalApplicationSummer summer, double minConsuming, double maxConsuming) throws IncorrectValueException {
        if (minConsuming >= 0 && maxConsuming >= 0 && minConsuming <= maxConsuming) {
            LinkedList<HomeElectricalApplication> result = new LinkedList<>();
            List<HomeElectricalApplication> applications = summer.getApps();
            for(HomeElectricalApplication application : applications) {
                if (application.getElectricityConsuming() >= minConsuming && application.getElectricityConsuming() <= maxConsuming){
                    result.add(application);
                }
            }
            return result;
        } else {
            throw new IncorrectValueException("Incorrect arguments");
        }
    }
}
