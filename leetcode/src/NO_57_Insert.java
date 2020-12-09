import java.util.ArrayList;
import java.util.List;

public class NO_57_Insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];

        boolean placed = false;

        List<int[]> ansList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i ++) {
            int[] interval = intervals[i];
            if (interval[1] < left) {
                ansList.add(interval);
            } else if (interval[0] > right) {

                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }

        if (placed == false) {
            ansList.add(new int[]{left, right});
        }

        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i ++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
