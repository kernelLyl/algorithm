import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class NO_3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end ++) {
            Character c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));

            }
            int length = end - start + 1;
            ans = Math.max(ans, length);
            map.put(c, end + 1);
        }
        System.out.println(ans);
    }
}
