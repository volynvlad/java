package by.bsu.lab.fourth.variantb.entity;

public class ElectricKettle extends HomeElectricalAppliance {

    {
        codeOfAppliances = 2;
    }

    @Override
    public int getPowerConsumption() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "Electric kettle";
    }
}
