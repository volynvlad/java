package by.bsu.secondlab.entity;

import java.util.ArrayList;

public class Paragraph {
    private ArrayList<Sequence> paragraph;

    public Paragraph() {}

    public Paragraph(ArrayList<Sequence> paragraph) {
        this.paragraph = paragraph;
    }

    public ArrayList<Sequence> getParagraph() {
        return paragraph;
    }

    public void setParagraph(ArrayList<Sequence> paragraph) {
        this.paragraph = paragraph;
    }

    public Sequence getSequence(int index) {
        return paragraph.get(index);
    }

    public int length() {
        if (paragraph != null) {
            return paragraph.size();
        } else {
            return 0;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sequence sequence : paragraph) {
            result.append(sequence.toString());
        }
        return result.toString();
    }
}
