import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2)
            return;

        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int c;
            boolean lastWasSpace = false;
            while ((c = reader.read()) != -1) {
                char character = (char) c;

                if (Character.isWhitespace(character)) {
                    lastWasSpace = true;
                } else {
                    if (lastWasSpace) {
                        writer.write(Character.toUpperCase(character));
                        lastWasSpace = false;
                    } else {
                        writer.write(character);
                    }
                }
            }
        }
    }
}