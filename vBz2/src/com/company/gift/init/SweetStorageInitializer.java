package com.company.gift.init;

import com.company.gift.create.SweetCreator;
import com.company.gift.exception.InvalidDataException;
import com.company.gift.exception.UnknownSweetException;
import com.company.gift.parse.SweetParser;
import com.company.gift.store.SweetStorage;

import com.company.gift.util.TypeSweet;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;


public class SweetStorageInitializer {
    private static final Logger LOGGER = LogManager.getLogger(SweetStorageInitializer.class);

    public SweetStorage init(LinkedList<String> strings) throws InvalidDataException {
        SweetStorage storage = SweetStorage.getInstance();
        TypeSweet typeSweet;
        SweetParser sweetParser;
        SweetCreator sweetCreator;
        while(!strings.isEmpty()){
            sweetParser = new SweetParser(strings.removeFirst());
            sweetCreator = new SweetCreator(sweetParser);
            try {
                typeSweet = sweetParser.takeSweetType();
                switch (typeSweet){
                    case GLAZED_CANDY:
                        storage.addSweet(sweetCreator.createGlazedCandy());
                        break;
                    case LOLLIPOP:
                        storage.addSweet(sweetCreator.createLollipop());
                        break;
                    case WAFER:
                        storage.addSweet(sweetCreator.createWafer());
                        break;
                    default:
                        throw new InvalidDataException("There is no such sweet!");
                }
            } catch (InvalidDataException e) {
                LOGGER.log(Level.ERROR, "String contain not valid sweet", e);
                throw new InvalidDataException("There is no such sweet!");
            }
        }
        return storage;
    }
}
