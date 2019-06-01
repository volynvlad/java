package by.bsu.vlad.lab10b.main;

import by.bsu.vlad.lab10b.huffmantree.HuffmanTree;

/**Вариант В
 * 3.Написать программу, осуществляющую сжатие английского текста.
 * Построить для каждого слова в тексте оптимальный префиксный код по ал-
 * горитму Хаффмена. Использовать класс PriorityQueue.
 */

public class Main {
    public static void main(String[] args) {
        String text = "it is itis";

        int[] charFrequencies = new int[256];

        for (char c : text.toCharArray()) {
            charFrequencies[c]++;
        }

        HuffmanTree tree = HuffmanTree.buildHuffmanTree(charFrequencies);
        System.out.printf("size before compression = %d%n", text.length() * 8);
        System.out.printf("размер перед сжатием = %d%n", text.length() * 8);
        String incoded = tree.incode(text);
        System.out.println("incoded result = " + incoded);
        System.out.printf("size after compression = %d%n", incoded.length());
        System.out.printf("размер после сжатия = %d%n", incoded.length());
        String decoded = tree.decode(incoded);
        System.out.println(decoded);

        tree.printCodes();
    }
}
