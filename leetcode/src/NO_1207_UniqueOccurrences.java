import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NO_1207_UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Set<Integer> times = new HashSet<>(map.size());

        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            times.add(x.getValue());
        }

        return map.size() == times.size();
    }
}
