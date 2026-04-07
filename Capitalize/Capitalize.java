
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Capitalize {

    public static void capitalize(String[] args) throws IOException {
        if (args.length != 2) {
            return;
        }
        String filename1 = args[0];
        String filename2 = args[1];
        Path path1 = Path.of(filename1);
        Path path2 = Path.of(filename2);
        String content = Files.readString(path1);
        String[] words = content.trim().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 0) {
                words[i] = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
            }
        }
        String result = String.join(" ", words);
        Files.writeString(path2, result);

    }
}