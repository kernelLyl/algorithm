public class NO_283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;

        while (right < n) {
            if (nums[right] != 0) {
                if (right != left) {
                    swap(nums, right, left);
                }
                left ++;
            }
            right ++;
        }
    }

    public void swap(int[] nums, int i , int j) {
        int m = nums[i];
        nums[i] = nums[j];
        nums[j] = m;
    }
}
