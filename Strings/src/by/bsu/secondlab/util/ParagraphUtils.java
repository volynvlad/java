package by.bsu.secondlab.util;

import by.bsu.secondlab.entity.Paragraph;
import by.bsu.secondlab.entity.Sequence;
import by.bsu.secondlab.exception.IncorrectValueException;

import java.util.ArrayList;

public class ParagraphUtils {

    public static Paragraph subParagraph(Paragraph paragraph, int startSequence, int endSequence) throws IncorrectValueException {
        if (startSequence >= 0 && endSequence >= 0
                && startSequence <= endSequence && endSequence <= paragraph.length()) {
            Paragraph resultParagraph = new Paragraph();
            ArrayList<Sequence> sequences = new ArrayList<>();
            for (int i = startSequence; i < endSequence; i++) {
                sequences.add(paragraph.getSequence(i));
            }
            resultParagraph.setParagraph(sequences);
            return resultParagraph;
        } else {
            throw new IncorrectValueException("Incorrect argument");
        }
    }

    public static Paragraph subParagraph(Paragraph paragraph, int endSequence) throws IncorrectValueException {
        if (endSequence >= 0 && endSequence <= paragraph.length()) {
            Paragraph resultParagraph = new Paragraph();
            ArrayList<Sequence> sequences = new ArrayList<>();
            for (int i = 0; i <= endSequence; i++) {
                sequences.add(paragraph.getSequence(i));
            }
            resultParagraph.setParagraph(sequences);
            return resultParagraph;
        } else {
            throw new IncorrectValueException("Incorrect argument");
        }
    }
}
