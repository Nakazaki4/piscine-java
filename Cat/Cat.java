import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }

        for (String filename : args) {
            File file = new File(filename);
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];

                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    System.out.write(buffer, 0, bytesRead);
                }
                System.out.flush();
            }
        }
    }
}