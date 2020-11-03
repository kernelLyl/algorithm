import java.util.*;

public class NO_381_RandomizedCollection {
    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;

    public NO_381_RandomizedCollection() {
        idx = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        int i = nums.size() - 1;
        Set<Integer> set = idx.getOrDefault(val, new HashSet<>());
        set.add(i);
        if (set.size() == 1) {
            idx.put(val, set);
        }
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }

        Set<Integer> set = idx.get(val);
        int i = set.iterator().next();
        int lastNumber = nums.get(nums.size() - 1);
        nums.set(i, lastNumber);

        set.remove(i);
        idx.get(lastNumber).remove(nums.size() - 1);
        if (i < nums.size() - 1) {
            idx.get(lastNumber).add(i);
        }
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(new Random().nextInt(nums.size()));
    }

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(1));
    }
}
