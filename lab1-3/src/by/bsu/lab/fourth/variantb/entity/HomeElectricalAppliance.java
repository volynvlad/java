package by.bsu.lab.fourth.variantb.entity;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class HomeElectricalAppliance implements Cloneable{
    private static AtomicInteger nextId = new AtomicInteger();
    private long                 idHomeElectricalAppliances;
    private boolean              connected;
    protected int                powerConsumption;
    protected int                codeOfAppliances;

    {
        connected = false;
        idHomeElectricalAppliances = nextId.incrementAndGet();
    }

    public long getIdHomeElectricalAppliances() {
        return idHomeElectricalAppliances;
    }

    public boolean isConnected() {
        return connected;
    }

    public abstract int getPowerConsumption();
    public abstract String getDescription();

    public void changeConnectedStatement() {
        this.connected = !this.connected;
    }

    public void display(){
        System.out.println("Id: " + getIdHomeElectricalAppliances() + ' ' + getDescription() + " with consumes power " + getPowerConsumption() +
                (this.isConnected() ? " is turned on" : " is turned off" ));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
