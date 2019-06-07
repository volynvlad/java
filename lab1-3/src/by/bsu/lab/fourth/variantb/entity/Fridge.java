package by.bsu.lab.fourth.variantb.entity;

public class Fridge extends HomeElectricalAppliance {

    {
        codeOfAppliances = 3;
    }

    @Override
    public int getPowerConsumption() {
        return 60;
    }

    @Override
    public String getDescription() {
        return "Fridge";
    }
}
