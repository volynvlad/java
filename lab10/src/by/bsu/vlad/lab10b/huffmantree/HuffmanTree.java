package by.bsu.vlad.lab10b.huffmantree;

import java.util.PriorityQueue;
public class HuffmanTree implements Comparable<HuffmanTree>{

    // корень дерева
    private Node root;

    public HuffmanTree(Node root) {
        this.root = root;
    }
    private static class Node {
        // Частота символа
        private Integer frequency;
        // Символ
        private Character character;
        // Левый потомок узла
        private Node leftChild;
        // Правый потомок узла
        private Node rightChild;

        public Node(Integer frequency, Character character) {
            this.frequency = frequency;
            this.character = character;
        }

        public Node(HuffmanTree left, HuffmanTree right) {
            frequency = left.root.frequency + right.root.frequency;
            leftChild = left.root;
            rightChild = right.root;
        }

        @Override
        public String toString() {
            return "[id=" + frequency + ", data =" + character + "]";
        }
    }

    public static HuffmanTree buildHuffmanTree(int[] charFrequencies) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();
        // 1. - 3.
        for (int i = 0; i < charFrequencies.length; i++) {
            if (charFrequencies[i] > 0) {
                trees.offer(new HuffmanTree(new Node(charFrequencies[i], (char)i)));
            }
        }
        // 6. пока в очереди не останется только одно дерево
        while (trees.size() > 1) {
            // 4. - 5.
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
            trees.offer(new HuffmanTree(new Node(a, b)));
        }
        /*Когда в очереди останется всего одно дерево, оно представляет собой дерево Хаффмана. */
        return trees.poll();
    }

    public String decode(String bytes) {
        StringBuilder result = new StringBuilder();
        //TODO #36
        return result.toString();
    }

    public String incode(String text) {
        /*Для кодирования сообщения необходимо создать кодовую таблицу,
         * в которой для каждого символа приводится соответствующий код Хаффмана.*/
        String[] codes = codeTable();
        StringBuilder result = new StringBuilder();
        /*Далее коды Хаффмана раз за разом присоединяются к кодированному сообщению,
         * пока оно не будет завершено.*/
        for (int i = 0; i < text.length(); i++) {
            result.append(codes[text.charAt(i)]);
        }
        return result.toString();
    }

    private String[] codeTable() {
        String[] codeTable = new String[256];
        codeTable(root, new StringBuilder(), codeTable);
        return codeTable;
    }

    private void codeTable(Node node, StringBuilder code, String[] codeTable) {
        if (node.character != null) {
            codeTable[(char)node.character] = code.toString();
            return;
        }
        codeTable(node.leftChild, code.append('0'), codeTable);
        code.deleteCharAt(code.length() - 1);
        codeTable(node.rightChild, code.append('1'), codeTable);
        code.deleteCharAt(code.length() - 1);
    }

    public void printCodes() {
        System.out.println("char\t frequency\t binary code");
        printCodes(root, new StringBuilder());
    }

    private void printCodes(Node current, StringBuilder code) {
        //если узел листовой
        if (current.character != null) {
            // выводим символ, частоту и код пути от корня до текущкго узла
            System.out.println(current.character + "\t " + current.frequency + "\t\t " + code);
        } else {
            // обходим левое поддерево
            printCodes(current.leftChild, code.append('0'));
            code.deleteCharAt(code.length() - 1);
            // обходим правое поддерево
            printCodes(current.rightChild, code.append('1'));
            code.deleteCharAt(code.length() - 1);
        }
    }

    @Override
    public int compareTo(HuffmanTree tree) {
        return root.frequency - tree.root.frequency;
    }

}
