import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        Collections.sort(list);
        return list;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) {
            return new ArrayList<>();
        }

        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }
}