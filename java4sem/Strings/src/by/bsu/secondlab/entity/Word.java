package by.bsu.secondlab.entity;

import java.util.ArrayList;

public class Word {
    private ArrayList<Symbol> word;

    public Word(){}

    public Word(ArrayList<Symbol> word) {
        this.word = word;
    }

    public ArrayList<Symbol> getWord() {
        return word;
    }

    public void setWord(ArrayList<Symbol> word) {
        this.word = word;
    }

    public int length() {
        if (word != null) {
            return word.size();
        } else {
            return 0;
        }
    }

    public boolean equals(Word word) {
        if (word == null || word.length() != this.length()) {
            return false;
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (!word.word.get(i).toString().equals(this.word.get(i).toString())) {
                    return false;
                }
            }
        }

        return true;
    }

    public String toString() {
        String result = "";
        for (Symbol symbol : word) {
            result += symbol.toString();
        }
        return result;
    }

    public boolean isEmpty() {
        return word.isEmpty();
    }
}
