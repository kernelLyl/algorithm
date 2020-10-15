import java.util.ArrayList;
import java.util.List;

public class NO_1002_CommonChars {
    public List<String> commonChars(String[] A) {
        int[] res = new int[26];
        for (char c : A[0].toCharArray()) {
            res[c - 'a'] ++;
        }

        for (int i = 1; i < A.length; i ++) {
            int[] temp = new int[26];
            for (char c : A[i].toCharArray()) {
                temp[c - 'a'] ++;
            }

            for (int j = 0; j < 26; j ++) {
                res[j] = Math.min(res[j], temp[j]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i ++) {
            if (res[i] > 0) {
                for (int j = 0; j < res[i]; j ++) {
                    result.add(((char) ('a' + i) + ""));
                }
            }
        }
        return result;
    }
}
