import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        int index = list.lastIndexOf(value);
        if (index == -1) {
            return null;
        }
        return index;
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        int index = list.indexOf(value);
        if (index == -1) {
            return null;
        }
        return index;
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        List<Integer> allIndexes = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), value)) {
                allIndexes.add(i);
            }
        }
        return allIndexes;
    }
}