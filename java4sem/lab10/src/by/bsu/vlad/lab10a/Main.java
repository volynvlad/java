package by.bsu.vlad.lab10a;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**Вариант А
 * 3.Создать список из элементов каталога и его подкаталогов.
 */

public class Main {
    private static ArrayList<File> dir = new ArrayList<>();
    public static void main(String[] args) {
        File myDir = new File("/home/vlad/Documents/bgsCNN");

        try {
            dir = list(myDir);
        } catch (IOException e) {
        }

        for (int i = 0; i < dir.size(); i++) {
            System.out.println(dir.get(i).getPath());
        }
    }

    public static ArrayList<File> list(File f) throws IOException {
        File[] currentSeekingFolderContent = f.listFiles();
        for (int i = 0; i < currentSeekingFolderContent.length; i++) {
            if (currentSeekingFolderContent[i].isDirectory()) {
                dir.add(currentSeekingFolderContent[i]);
                list(currentSeekingFolderContent[i]);
            }
        }
        return dir;
    }
}
