package by.bsu.lab.fourth.variantb.entity;

public class TableLamp extends HomeElectricalAppliance {

    {
        codeOfAppliances = 6;
    }

    @Override
    public int getPowerConsumption() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Table lamp";
    }


}
