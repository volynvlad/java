package by.bsu.homeapplication.compare;

import by.bsu.homeapplication.entity.HomeElectricalApplication;

import java.util.Comparator;

public class ConsumingHomeElectricalApplicationComparator implements Comparator<HomeElectricalApplication> {
    @Override
    public int compare(HomeElectricalApplication o1, HomeElectricalApplication o2) {
        if(o1.getElectricityConsuming() > o2.getElectricityConsuming()){
            return 1;
        }else if(o1.getElectricityConsuming() < o2.getElectricityConsuming()){
            return -1;
        }else{
            return 0;
        }
    }
}
