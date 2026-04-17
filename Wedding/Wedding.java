import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Wedding {
    
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        List<String> firstList = new ArrayList<>(first);
        List<String> secondList = new ArrayList<>(second);
        
        Collections.shuffle(firstList);
        Collections.shuffle(secondList);
        
        Map<String, String> couples = new HashMap<>();
        
        int minSize = Math.min(firstList.size(), secondList.size());
        
        for (int i = 0; i < minSize; i++) {
            couples.put(firstList.get(i), secondList.get(i));
        }
        
        return couples;
    }
}