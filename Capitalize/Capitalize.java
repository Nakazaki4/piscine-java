import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2) return;

        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        try (Scanner sc = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                
                String capitalizedLine = Arrays.stream(line.split(" "))
                    .map(word -> cap(word))
                    .collect(Collectors.joining(" "));
                
                writer.println(capitalizedLine);
            }
        }
    }

    private static String cap(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}