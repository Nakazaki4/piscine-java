import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }

        InputStream is = System.in;

        OutputStream[] outputs = new OutputStream[args.length];
        for (int i = 0; i < args.length; i++) {
            outputs[i] = Files.newOutputStream(Path.of(args[i]), StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        }

        byte[] buffer = new byte[4096];
        int bytesRead;

        try {
            while ((bytesRead = is.read(buffer)) != -1) {
                for (OutputStream os : outputs) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        } finally {
            for (OutputStream os: outputs) {
                os.close();
            }
        }

    }
}