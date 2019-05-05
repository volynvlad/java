package by.bsu.secondlab.util;

import by.bsu.secondlab.entity.Paragraph;
import by.bsu.secondlab.entity.Sequence;
import by.bsu.secondlab.entity.Word;

public class IsWordInParagraph {
    public static boolean isWordInParagraph(Word word, Paragraph paragraph) {
        if (word != null) {
            for (Sequence sequence : paragraph.getParagraph()) {
                if (IsWordInSequence.isWordInSequence(word, sequence)) {
                    return true;
                }
            }
        }
        return false;
    }
}
