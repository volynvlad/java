package by.bsu.lab.fourth.variantb.entity;

public class WashingMachine extends HomeElectricalAppliance {

    {
        codeOfAppliances = 7;
    }

    @Override
    public int getPowerConsumption() {
        return 40;
    }

    @Override
    public String getDescription() {
        return "Washing machine";
    }

}
