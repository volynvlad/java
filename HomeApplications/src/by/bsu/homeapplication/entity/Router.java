package by.bsu.homeapplication.entity;

public class Router extends HomeElectricalApplication {
    public Router(long homeAppId, String name, Producer producer, double electricityConsuming, String connected, Type type) {
        super(homeAppId, name, producer, electricityConsuming, connected, type);
    }

    @Override
    public String toString() {
        return "Router{" +
                "id=" + getHomeAppId() +
                ", name=" + getName() +
                ", producer=" + getProducer() +
                ", electricity consuming=" + getElectricityConsuming() +
                ", connection= " + getConnected() +
                "}\n";
    }
}
