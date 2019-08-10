package by.bsu.homeapplication.valid;


import by.bsu.homeapplication.entity.Producer;
import by.bsu.homeapplication.entity.Type;
import by.bsu.homeapplication.utils.HomeElectricalApplicationTags;

public class HomeElectricalApplicationValidor {
    public static boolean isValidHomeElectricalApplication(String homeElectricalApplication) {
        homeElectricalApplication = homeElectricalApplication.toUpperCase();
        return homeElectricalApplication.contains(HomeElectricalApplicationTags.ID) && homeElectricalApplication.contains(HomeElectricalApplicationTags.NAME)
                && homeElectricalApplication.contains(HomeElectricalApplicationTags.PRODUCER) && homeElectricalApplication.contains(HomeElectricalApplicationTags.CONSUMING)
                && homeElectricalApplication.contains(HomeElectricalApplicationTags.CONNECTED);
    }

    public static boolean isValidProducer(String producerStr) {
        Producer[] producers = Producer.values();
        for (Producer producer : producers) {
            if (producer.toString().equalsIgnoreCase(producerStr)){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidHomeElectricalApplicationType(String typeAppStr) {
        Type[] typeApps = Type.values();
        for (Type typeApp : typeApps) {
            if (typeApp.toString().equalsIgnoreCase(typeAppStr)){
                return true;
            }
        }
        return false;
    }

}
