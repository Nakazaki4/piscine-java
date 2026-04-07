
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        Files.createFile(Path.of(fileName));
        Files.writeString(Path.of(fileName), content);
    }

    public static String getContentFile(String fileName) throws IOException {
        return Files.readString(Path.of(fileName));
    }

    public static void deleteFile(String fileName) {
        try {
            Files.delete(Path.of(fileName));
        } catch (Exception e) {
        }
    }
}