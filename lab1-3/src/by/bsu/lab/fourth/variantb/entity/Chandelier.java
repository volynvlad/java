package by.bsu.lab.fourth.variantb.entity;

public class Chandelier extends HomeElectricalAppliance {

    {
        codeOfAppliances = 1;
    }

    @Override
    public int getPowerConsumption() {
        return 20;
    }

    @Override
    public String getDescription() {
        return "Chandelier";
    }
}
