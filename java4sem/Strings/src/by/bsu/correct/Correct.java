package by.bsu.correct;

public class Correct {
    /**
     * if we have p before a and ' ' after p
     * replace a with o
     */
    public static String correct(String text) {
        StringBuilder stringBuilder = new StringBuilder(text.length());

        for (int i = 0; i < text.length(); i++) {
            boolean b = i > 1 && i < text.length() - 1 && ((text.charAt(i - 1) == 'p') || (text.charAt(i - 1)) == 'P');
            char ch = text.charAt(i);
            if (b && ch == 'a' && text.charAt(i + 1) == ' ') {
                stringBuilder.append('o');
            } else if (b && ch == 'A' && text.charAt(i + 1) == ' ') {
                stringBuilder.append('O');
            } else {
                stringBuilder.append(ch);
            }
        }

        text = stringBuilder.toString();
        return text;
    }
}
