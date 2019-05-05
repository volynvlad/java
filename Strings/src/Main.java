import by.bsu.correct.Correct;
import by.bsu.divide.Divider;
import by.bsu.graph.Graph;
import by.bsu.remove.Remover;
import by.bsu.secondlab.entity.Paragraph;
import by.bsu.secondlab.entity.Sequence;
import by.bsu.secondlab.entity.Word;
import by.bsu.secondlab.exception.IncorrectValueException;
import by.bsu.secondlab.util.IsWordInParagraph;
import by.bsu.secondlab.util.ParagraphUtils;
import by.bsu.submatrix.SubMatrix;

import java.util.ArrayList;

/**
 * 7 lab
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("*********** A **********");
        SubMatrix subMatrix = new SubMatrix();
        String s = "paRanekjifA iojnpA ijaijo iojipa iojipa";
        System.out.println("Input string: \n" + s);
        String result = Correct.correct(s);
        System.out.println("Output string: \n" + result);

        System.out.println("*********** B **********");

        String text = "code to your Android." +
                "library that Gradle." +
                "To Android learn more about." +
                "Android code native. ";
        System.out.println("Input text");
        System.out.println(text);
        Paragraph paragraph = by.bsu.secondlab.divide.Divider.dividerToSequences(text);
        Sequence firstSequence = paragraph.getSequence(0);

        System.out.println("Before");
        System.out.println(firstSequence.toString());

        try {
            ArrayList<Word> resultWordsArray = new ArrayList<>();
            Paragraph anotherParagraph = ParagraphUtils.subParagraph(paragraph, 1, paragraph.length());
            for (Word word : firstSequence.getWords()) {
                if(!IsWordInParagraph.isWordInParagraph(word, anotherParagraph)) {
                    resultWordsArray.add(word);
                }
            }
            Sequence resultWords = new Sequence(resultWordsArray);
            System.out.println("After");
            System.out.println(resultWords.toString());
        } catch (IncorrectValueException e) {
            e.printStackTrace();
        }





        System.out.println("*********** C **********");
        text = "code to your Android ." +
                "library that Gradle." +
                "To Android learn more about." +
                " Android code native.";
        System.out.println("Input text");
        System.out.println(text);
        System.out.println("------------------------------");
        System.out.println("Text divided by sequences");
        System.out.println("------------------------------");

        for(String string : Divider.dividerToSequences(text)) {
            System.out.println(string);
            /*
            for (String word : Divider.dividerToWords(string)) {
                System.out.println(word);
            }
            */
        }

        ArrayList<Integer> indexes = subMatrix.getIndexes(Graph.inceadentMatrix(
                Divider.dividerToSequences(text),
                Divider.dividerToSequences(text)));
        ArrayList<String> results = Remover.remover(Divider.dividerToSequences(text), indexes);
        System.out.println("------------------------------");
        System.out.println("Sequences with same words");
        System.out.println("------------------------------");
        for (String resultSeq : results) {
            System.out.println(resultSeq);
        }
    }
}
