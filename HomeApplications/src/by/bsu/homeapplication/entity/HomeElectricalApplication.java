package by.bsu.homeapplication.entity;

public abstract class HomeElectricalApplication {
    private long homeAppId;
    private String name;
    private Producer producer;
    private double electricityConsuming;
    private String connected;
    private Type type;


    public HomeElectricalApplication(long homeAppId, String name, Producer producer, double electricityConsuming, String connected, Type type) {
        this.homeAppId = homeAppId;
        this.name = name;
        this.producer = producer;
        this.electricityConsuming = electricityConsuming;
        this.connected = connected;
        // this.type = getClass().getSimpleName();
        this.type = type;
    }

    public HomeElectricalApplication() {

    }

    public long getHomeAppId() {
        return homeAppId;
    }

    public String getName() {
        return name;
    }

    public Producer getProducer() {
        return producer;
    }

    public double getElectricityConsuming() {
        return electricityConsuming;
    }

    public String getConnected() {
        return connected;
    }

    public Type getType() {
        return type;
    }
}
