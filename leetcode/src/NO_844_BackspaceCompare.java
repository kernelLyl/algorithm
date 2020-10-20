public class NO_844_BackspaceCompare {
    public static boolean backspaceCompare(String S, String T) {
        int m = S.length() - 1;
        int n = T.length() - 1;

        int skipS = 0;
        int skipT = 0;


        while (m >= 0 || n >= 0) {
            while (m >= 0) {
                if (S.charAt(m) == '#') {
                    skipS ++;
                    m --;
                } else if (skipS > 0) {
                    skipS --;
                    m --;
                } else {
                    break;
                }
            }
            while (n >= 0) {
                if (T.charAt(n) == '#') {
                    skipT ++;
                    n --;
                } else if (skipT > 0) {
                    skipT --;
                    n --;
                } else {
                    break;
                }
            }

            if (m >= 0 && n >= 0) {
                if (S.charAt(m) == T.charAt(n)) {
                    m --;
                    n --;
                } else {
                    return false;
                }
            } else {
                if (m >= 0 || n >= 0) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("bbbextm",
                "bbb#extm"));
    }
}
