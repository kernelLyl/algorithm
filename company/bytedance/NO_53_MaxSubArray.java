public class NO_53_MaxSubArray {
    public int maxsumofSubarray (int[] arr) {
        // write code here
        int sum = 0;
        int cur = 0;
        int s = 0;
        int e = 0;
        while (e < arr.length) {
            if (cur + arr[e] < 0) {
                cur = 0;
            } else {
                cur = cur + arr[e];
            }
            sum = Math.max(cur, sum);
            e ++;
        }
        return sum;
    }
}
