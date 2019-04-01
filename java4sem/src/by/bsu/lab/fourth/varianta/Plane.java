package by.bsu.lab.fourth.varianta;

import by.bsu.lab.fourth.varianta.Chassis.Chassis;
import by.bsu.lab.fourth.varianta.Engine.Engine;
import by.bsu.lab.fourth.varianta.Wing.Wing;

import java.util.ArrayList;

public abstract class Plane {
    private Chassis chassis;
    private Wing wing;
    private Engine engine;
    private ArrayList<String> marshrut;
    public void fly() {
        System.out.println("Fly on default speed - 885 km/hr");
    }

    public ArrayList<String> getMarshrut() {
        return marshrut;
    }

    public void setMarshrut(ArrayList<String> marshrut) {
        this.marshrut = marshrut;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public Wing getWing() {
        return wing;
    }

    public void setWing(Wing wing) {
        this.wing = wing;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "chassis=" + chassis.toString() +
                ", wing=" + wing.toString() +
                ", engine=" + engine.toString() +
                ", marshrut=" + marshrut +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
