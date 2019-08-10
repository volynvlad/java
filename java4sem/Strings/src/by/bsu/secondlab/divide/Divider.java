package by.bsu.secondlab.divide;

import by.bsu.secondlab.entity.*;

import java.util.ArrayList;

public class Divider {
    public static Paragraph dividerToSequences(String text) {
        Paragraph resultParagraph = new Paragraph();
        ArrayList<Sequence> result = new ArrayList<>();
        Word tmpWord;
        Sequence tmpSequence;
        ArrayList<Symbol> word = new ArrayList<>();
        ArrayList<Word> sequence = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char curChar = text.charAt(i);
            if (curChar != PunctuationMark.point &&
                    curChar != PunctuationMark.exclamationMark &&
                    curChar != PunctuationMark.questionMark) {
                if (curChar != ' ') {
                    word.add(new Symbol(curChar));
                } else {
                    tmpWord = new Word(word);
                    word = new ArrayList<>();
                    sequence.add(tmpWord);
                }
            } else {
                tmpWord = new Word(word);
                word = new ArrayList<>();
                sequence.add(tmpWord);
                tmpSequence = new Sequence(sequence);
                sequence = new ArrayList<>();
                result.add(tmpSequence);
            }
        }
        resultParagraph.setParagraph(result);
        return resultParagraph;
    }
}
