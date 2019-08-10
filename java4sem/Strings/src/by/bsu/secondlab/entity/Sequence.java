package by.bsu.secondlab.entity;

import java.util.ArrayList;

public class Sequence {
    private ArrayList<Word> sequence;

    public Sequence(){}

    public Sequence(ArrayList<Word> words) {
        this.sequence = words;
    }

    public ArrayList<Word> getWords() {
        return sequence;
    }

    public void setWords(ArrayList<Word> words) {
        this.sequence = words;
    }

    public int length() {
        if (sequence != null) {
            return sequence.size();
        } else {
            return 0;
        }
    }

    public String toString() {
        String result = "";
        for (Word word : sequence) {
            result += ' ' + word.toString();
        }
        return result;
    }
}
