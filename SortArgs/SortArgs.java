
import java.util.Arrays;

public class SortArgs {
    public static void sort(String[] args) {
        if (args == null){
            return;
        }
        Arrays.sort(args);
        System.out.println(String.join(" ", args));
    }
}