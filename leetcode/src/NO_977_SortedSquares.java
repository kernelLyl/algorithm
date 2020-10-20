public class NO_977_SortedSquares {
    public int[] sortedSquares(int[] A) {

        int n = A.length;

        int[] ans = new int[n];

        for (int l = 0, r = n - 1, pos = n - 1; pos >= 0; ) {
            int lS = A[l] * A[l];
            int rS = A[r] * A[r];

            if (lS > rS) {
                ans[pos] = lS;
                l ++;
            } else {
                ans[pos] = rS;
                r --;
            }
            pos --;
        }

        return ans;

    }
}
