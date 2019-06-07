package by.bsu.lab.fourth.variantb.entity;

public class SandwichMaker extends HomeElectricalAppliance {

    {
        codeOfAppliances = 5;
    }

    @Override
    public int getPowerConsumption() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Sandwich maker";
    }
}
