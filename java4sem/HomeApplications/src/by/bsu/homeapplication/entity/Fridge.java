package by.bsu.homeapplication.entity;

public class Fridge extends HomeElectricalApplication {
    public Fridge(long homeAppId, String name, Producer producer, double electricityConsuming, String connected, Type type) {
        super(homeAppId, name, producer, electricityConsuming, connected, type);
    }

    @Override
    public String toString() {
        return "Fridge{}"+
                "id=" + getHomeAppId() +
                ", name=" + getName() +
                ", producer=" + getProducer() +
                ", electricity consuming=" + getElectricityConsuming() +
                ", connection= " + getConnected() +
                "}\n";
    }
}
