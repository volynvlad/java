package com.company.gift.action;


import com.company.gift.compare.SweetNameComparator;
import com.company.gift.compare.SweetWeightComparator;
import com.company.gift.entity.Gift;
import com.company.gift.entity.Sweet;
import com.company.gift.exception.InvalidDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.LinkedList;

public class SweetSorter {
    private static final Logger LOGGER = LogManager.getLogger(SweetSorter.class);

    public void sortByNameThenWeight(Gift gift){
        LinkedList<Sweet> sweets = gift.getSweets();
        Collections.sort(sweets, new SweetNameComparator().thenComparing(new SweetWeightComparator()));
        try{
            gift.setSweets(sweets);
        } catch (InvalidDataException e) {
            LOGGER.log(Level.ERROR, "Problem with set sweets to gift", e);
        }
    }
}
