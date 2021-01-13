import java.util.Arrays;

public class NO_455_FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int greedSize = g.length;
        int sizeSize = s.length;

        int ans = 0;

        for (int i = greedSize - 1, j = sizeSize - 1; j >= 0 && i >= 0; i--) {
            if (g[i] <= s[j]) {
                j--;
                ans++;
            }
        }
        return ans;
    }
}
