package by.bsu.lab.fourth.variantb.entity;

public class Laptop extends HomeElectricalAppliance {

    {
        codeOfAppliances = 4;
    }

    @Override
    public int getPowerConsumption() {
        return 50;
    }

    @Override
    public String getDescription() {
        return "Laptop";
    }
}
