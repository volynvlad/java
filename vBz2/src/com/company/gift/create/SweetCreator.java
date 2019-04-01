package com.company.gift.create;

import com.company.gift.entity.GlazedCandy;
import com.company.gift.entity.Lollipop;
import com.company.gift.entity.Wafer;
import com.company.gift.exception.InvalidDataException;
import com.company.gift.parse.SweetParser;

public class SweetCreator {
    private SweetParser sweetParser;

    public SweetCreator(SweetParser parser) {
        this.sweetParser = parser;
    }

    public GlazedCandy createGlazedCandy() throws InvalidDataException {
        return new GlazedCandy(sweetParser.takeSweetId(),sweetParser.takeSweetName(), sweetParser.takeSweetProducer(), sweetParser.takeSweetWeight(), sweetParser.takeSweetSugar(), sweetParser.takeSweetTaste(), sweetParser.takeSweetFrosting());
    }

    public Lollipop createLollipop() throws InvalidDataException {
        return new Lollipop(sweetParser.takeSweetId(), sweetParser.takeSweetName(), sweetParser.takeSweetProducer(), sweetParser.takeSweetWeight(), sweetParser.takeSweetSugar(),  sweetParser.takeSweetTaste(), sweetParser.takeSweetForm());
    }

    public Wafer createWafer() throws InvalidDataException {
        return new Wafer(sweetParser.takeSweetId(), sweetParser.takeSweetName(), sweetParser.takeSweetProducer(), sweetParser.takeSweetWeight(), sweetParser.takeSweetSugar(), sweetParser.takeSweetAroma());
    }

}
