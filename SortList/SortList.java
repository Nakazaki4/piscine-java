import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        Collections.sort(list);
        return list;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) {
            return null;
        }

        if (list.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> sortedList = new ArrayList<>(list);

        sortedList.sort(Collections.reverseOrder());

        return sortedList;
    }
}