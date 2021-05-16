import java.io.PrintStream;
import java.util.*;

public class NO_3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
            int ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            int start = 0;
            for (int i = 0; i < s.length(); i ++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    start = Math.max(start, map.get(c));
                }
                map.put(c, i);
                int length = i - start + 1;
                ans = Math.max(ans, length);

            }

        System.out.println(ans);
    }
}
