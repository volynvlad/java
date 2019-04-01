package com.company.gift.parse;

import com.company.gift.entity.*;
import com.company.gift.exception.InvalidDataException;
import com.company.gift.util.SweetTags;
import com.company.gift.util.TypeSweet;
import com.company.gift.valid.SweetValidator;

import java.util.Locale;
import java.util.Scanner;

public class SweetParser {
    private String source;

    public SweetParser(String source) {
        this.source = source.toUpperCase();
    }

    public TypeSweet takeSweetType() throws InvalidDataException {
        if(SweetValidator.isValidSweet(this.source)) {
            int index = source.indexOf(SweetTags.TYPE) + SweetTags.TYPE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String sweetTypeStr = scanner.next();
            if(SweetValidator.isValidSweetType(sweetTypeStr)) {
                return TypeSweet.valueOf(sweetTypeStr);//static enumType valueOf(String arg) — создает элемент пере числения, соответствующий значению передаваемой строки;

            }else{
                throw new InvalidDataException("Not valid sweetType");
            }
        }else{
            throw new InvalidDataException("Not valid sweet");
        }
    }

    public String takeSweetName() throws InvalidDataException {
        if(SweetValidator.isValidSweet(this.source)) {
            int index = source.indexOf(SweetTags.NAME) + SweetTags.NAME.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            return scanner.next();
        }else{
            throw new InvalidDataException("Not valid sweet");
        }
    }

    public Producer takeSweetProducer() throws InvalidDataException {
        if(SweetValidator.isValidSweet(this.source)){
            int index = source.indexOf(SweetTags.PRODUCER) + SweetTags.PRODUCER.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String producerStr = scanner.next();
            if(SweetValidator.isValidProducer(producerStr)){
                return Producer.valueOf(producerStr);
            }
            else{
                throw new InvalidDataException("Producer not valid");
            }
        }else{
            throw new InvalidDataException("Not valid sweet");
        }
    }

    public long takeSweetId() throws InvalidDataException {
        if(SweetValidator.isValidSweet(this.source)){
            int index = source.indexOf(SweetTags.ID) + SweetTags.ID.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            return scanner.nextLong();
        }else{
            throw new InvalidDataException("Not valid sweet");
        }
    }

    public float takeSweetWeight() throws InvalidDataException {
        if(SweetValidator.isValidSweet(this.source)){
            int index = source.indexOf(SweetTags.WEIGHT) + SweetTags.WEIGHT.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            scanner.useLocale(Locale.US);
            return scanner.nextFloat();
        }{
            throw new InvalidDataException("Not valid sweet");
        }
    }

    public float takeSweetSugar() throws InvalidDataException {
        if(SweetValidator.isValidSweet(this.source)){
            int index = source.indexOf(SweetTags.SUGAR) + SweetTags.SUGAR.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            scanner.useLocale(Locale.US);
            return scanner.nextFloat();
        }{
            throw new InvalidDataException("Not valid sweet");
        }
    }

    public Taste takeSweetTaste() throws InvalidDataException {
        if(SweetValidator.isValidCandy(this.source)){
            int index = source.indexOf(SweetTags.TASTE) + SweetTags.TASTE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String tasteStr = scanner.next();
            if(SweetValidator.isValidTaste(tasteStr)) {
                return Taste.valueOf(tasteStr);
            }else{
                throw new InvalidDataException("Not valid taste");
            }
        }else{
            throw new InvalidDataException("Not valid sweet");
        }
    }

    public Frosting takeSweetFrosting() throws InvalidDataException {
        if(SweetValidator.isValidGlazedCandy(this.source)){
            int index = source.indexOf(SweetTags.FROSTING) + SweetTags.FROSTING.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String frostingStr = scanner.next();
            if(SweetValidator.isValidFrosting(frostingStr)) {
                return Frosting.valueOf(frostingStr);
            }else{
                throw new InvalidDataException("Not valid frosting");
            }
        }else{
            throw new InvalidDataException("Not valid sweet");
        }
    }

    public Form takeSweetForm() throws InvalidDataException {
        if(SweetValidator.isValidLollipop(this.source)){
            int index = source.indexOf(SweetTags.FORM) + SweetTags.FORM.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String formStr = scanner.next();
            if(SweetValidator.isValidForm(formStr)) {
                return Form.valueOf(formStr);
            }else {
                throw new InvalidDataException("Not valid form");
            }
        }else{
            throw new InvalidDataException("Not valid sweet");
        }
    }

    public Aroma takeSweetAroma() throws InvalidDataException {
        if(SweetValidator.isValidWafer(this.source)){
            int index = source.indexOf(SweetTags.AROMA) + SweetTags.AROMA.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String aromaStr = scanner.next();
            if(SweetValidator.isValidAroma(aromaStr)) {
                return Aroma.valueOf(aromaStr);
            }else{
                throw new InvalidDataException("Not valid aroma");
            }
        }else{
            throw new InvalidDataException("Not valid sweet");
        }
    }
}
