import java.util.Arrays;

public class NO_724_PivotIndex {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();

        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
