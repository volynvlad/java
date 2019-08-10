package by.bsu.homeapplication.parser;

import by.bsu.homeapplication.entity.HomeElectricalApplication;
import by.bsu.homeapplication.entity.Type;
import by.bsu.homeapplication.valid.HomeElectricalApplicationValidor;
import by.bsu.homeapplication.entity.Producer;
import by.bsu.homeapplication.exception.InvalidDataException;
import by.bsu.homeapplication.utils.HomeElectricalApplicationTags;

import java.util.Locale;
import java.util.Scanner;

public class HomeElectricalApplicationParser {
    private String source;

    public HomeElectricalApplicationParser(String source) {
        this.source = source.toUpperCase();
    }

    public String takeHomeElectricalApplicationName() throws InvalidDataException {
        if(HomeElectricalApplicationValidor.isValidHomeElectricalApplication(this.source)) {
            int index = source.indexOf(HomeElectricalApplicationTags.NAME) + HomeElectricalApplicationTags.NAME.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            return scanner.next();
        } else {
            throw new InvalidDataException("Not valid home electrical application");
        }
    }

    public Producer takeHomeElectricalApplicationProducer() throws InvalidDataException {
        if(HomeElectricalApplicationValidor.isValidHomeElectricalApplication(this.source)) {
            int index = source.indexOf(HomeElectricalApplicationTags.PRODUCER) + HomeElectricalApplicationTags.PRODUCER.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String producerStr = scanner.next();
            if (HomeElectricalApplicationValidor.isValidProducer(producerStr)) {
                return Producer.valueOf(producerStr);
            } else {
                throw new InvalidDataException("Producer not valid");
            }
        } else {
            throw new InvalidDataException("Not valid home electricity application");
        }
    }

    public Type takeHomeElectricalApplicationType() throws InvalidDataException {
        if(HomeElectricalApplicationValidor.isValidHomeElectricalApplication(this.source)) {
            int index = source.indexOf(HomeElectricalApplicationTags.TYPE) + HomeElectricalApplicationTags.TYPE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String typeStr = scanner.next();
            if (HomeElectricalApplicationValidor.isValidHomeElectricalApplicationType(typeStr)) {
                return Type.valueOf(typeStr);
            } else {
                throw new InvalidDataException("Producer not valid");
            }
        } else {
            throw new InvalidDataException("Not valid home electricity application");
        }
    }

    public long takeHomeElectricalApplicationId() throws InvalidDataException {
        if(HomeElectricalApplicationValidor.isValidHomeElectricalApplication(this.source)) {
            int index = source.indexOf(HomeElectricalApplicationTags.ID) + HomeElectricalApplicationTags.ID.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            return scanner.nextLong();
        } else {
            throw new InvalidDataException("Not valid home electrical application");
        }
    }

    public double takeHomeElectricalApplicationConsuming() throws InvalidDataException {
        if(HomeElectricalApplicationValidor.isValidHomeElectricalApplication(this.source)){
            int index = source.indexOf(HomeElectricalApplicationTags.CONSUMING) + HomeElectricalApplicationTags.CONSUMING.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            scanner.useLocale(Locale.US);
            return scanner.nextDouble();
        } else {
            throw new InvalidDataException("Not valid nome electrical application");
        }
    }

    public String takeHomeElectricalApplicationConnected() throws InvalidDataException {
        if(HomeElectricalApplicationValidor.isValidHomeElectricalApplication(this.source)) {
            int index = source.indexOf(HomeElectricalApplicationTags.CONNECTED) + HomeElectricalApplicationTags.CONNECTED.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            return scanner.next();
        } else {
            throw new InvalidDataException("Not valid home electrical application");
        }
    }
}
