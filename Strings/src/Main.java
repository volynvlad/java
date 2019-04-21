import by.bsu.correct.Correct;
import by.bsu.divide.Divider;
import by.bsu.graph.Graph;
import by.bsu.remove.Remover;
import by.bsu.submatrix.SubMatrix;

import java.util.ArrayList;

/**
 * 7 lab
 */

public class Main {
    public static void main(String[] args) {
        SubMatrix subMatrix = new SubMatrix();
        String s = "paRanekjifA iojnpA ijaijo iojipa iojipa";
        System.out.println("Input string: \n" + s);
        String result = Correct.correct(s);
        System.out.println("Output string: \n" + result);

        System.out.println("------------------------------");
        String text = "code to your Android ." +
                "library that Gradle." +
                "To Android learn more about." +
                " Android Kotlin native.";
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
