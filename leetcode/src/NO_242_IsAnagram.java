public class NO_242_IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i ++) {
            int c = s.charAt(i) - 'a';
            hash[c] ++;
        }

        for (int j = 0; j < t.length(); j ++) {
            int c = t.charAt(j) - 'a';

            hash[c] --;
            if (hash[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
