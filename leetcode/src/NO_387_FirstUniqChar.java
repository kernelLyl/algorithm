import java.util.HashMap;
import java.util.Map;

public class NO_387_FirstUniqChar {
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] hash = new int['z' - 'a' + 1];

        for (int i = 0; i < hash.length; i ++) {
            hash[i] = -2;
        }

        for (int i = 0; i < chars.length; i ++) {
            int c = chars[i] - 'a';
            if (hash[c] == -2) {
                hash[c] = i;
            } else {
                hash[c] = -1;
            }
        }
        int first = chars.length;
        for (int i = 0; i < hash.length; i ++) {
            if (hash[i] != -1 && hash[i] != -2 && hash[i] < first) {
                first = hash[i];
            }
        }
        if (first == chars.length) {
            return -1;
        }
        return first;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
