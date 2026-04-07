
import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        File root = new File("documents");
        if (!root.exists() || !root.isDirectory()) {
            return null;
        }
        return findFile(root, fileName);
    }

    private static String findFile(File root, String filename) {
        File[] files = root.listFiles();
        if (files == null) {
            return null;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                String res = findFile(file, filename);
                if (res != null) {
                    return res;
                }
            } else if (file.getName().equals(filename)) {
                return file.getPath();
            }
        }
        return null;
    }
}