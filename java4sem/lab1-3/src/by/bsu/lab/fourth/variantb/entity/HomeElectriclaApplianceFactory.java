package by.bsu.lab.fourth.variantb.entity;
import by.bsu.lab.basic.FormRandomNumber;

public class HomeElectriclaApplianceFactory {
    public HomeElectricalAppliance[] generateHomeElectricalAppliances(int number) {
        HomeElectricalAppliance[] homeElectricalAppliances = new HomeElectricalAppliance[number];
        FormRandomNumber formRandomNumber = new FormRandomNumber();
        for (int i = 0;i < number; i++) {
            switch (formRandomNumber.generateRandomNumber(1, 7)) {
                case 1:
                    homeElectricalAppliances[i] = new Chandelier();
                    break;
                case 2:
                    homeElectricalAppliances[i] = new ElectricKettle();
                    break;
                case 3:
                    homeElectricalAppliances[i] = new Fridge();
                    break;
                case 4:
                    homeElectricalAppliances[i] = new Laptop();
                    break;
                case 5:
                    homeElectricalAppliances[i] = new SandwichMaker();
                    break;
                case 6:
                    homeElectricalAppliances[i] = new TableLamp();
                    break;
                case 7:
                    homeElectricalAppliances[i] = new WashingMachine();
                    break;

            }
        }
        return homeElectricalAppliances;
    }

    public void turnOn(HomeElectricalAppliance[] homeElectricalAppliances) {
        FormRandomNumber formRandomNumber = new FormRandomNumber();
        for (int i = 0; i < homeElectricalAppliances.length / 2; i++) {
            if (formRandomNumber.generateRandomNumber(1, 7) % 2 == 0) {
                homeElectricalAppliances[i].changeConnectedStatement();
            }
        }
    }

    public int totalPowerConsuming(HomeElectricalAppliance[] homeElectricalAppliances) {
        int result = 0;
        for (int i = 0; i < homeElectricalAppliances.length; i++) {
            if (homeElectricalAppliances[i].isConnected()) {
                result += homeElectricalAppliances[i].getPowerConsumption();
            }
        }
        return result;
    }

    public HomeElectricalAppliance[] sortByConsuming(HomeElectricalAppliance[] homeElectricalAppliances) throws CloneNotSupportedException {
        for (int i = 0; i < homeElectricalAppliances.length; i++) {
            for (int j = 0; j < homeElectricalAppliances.length; j++) {
                if (homeElectricalAppliances[j].getPowerConsumption()
                        > homeElectricalAppliances[i].getPowerConsumption()) {
                    HomeElectricalAppliance tmp = (HomeElectricalAppliance) homeElectricalAppliances[j].clone();
                    homeElectricalAppliances[j] = (HomeElectricalAppliance) homeElectricalAppliances[i].clone();
                    homeElectricalAppliances[i] = (HomeElectricalAppliance) tmp.clone();
                }
            }
        }
        return homeElectricalAppliances;
    }

    public void display(HomeElectricalAppliance[] homeElectricalAppliances) {
        for (int i = 0; i < homeElectricalAppliances.length; i++) {
            homeElectricalAppliances[i].display();
        }
    }
}
