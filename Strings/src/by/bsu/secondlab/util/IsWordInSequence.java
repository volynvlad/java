package by.bsu.secondlab.util;

import by.bsu.secondlab.entity.Sequence;
import by.bsu.secondlab.entity.Word;

public class IsWordInSequence {
    public static boolean isWordInSequence(Word word, Sequence sequence) {
        if (word != null) {
            for (Word tmpWord : sequence.getWords()) {
                if (word.equals(tmpWord)) {
                    return true;
                }
            }
        }
        return false;
    }
}
