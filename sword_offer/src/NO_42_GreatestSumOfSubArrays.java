public class NO_42_GreatestSumOfSubArrays {

    private int[] max;

    public int FindGreatestSumOfSubArray(int[] array) {
        max = new int[array.length];
        if (array.length == 0) {
            return 0;
        }

        int m = array[0];

        for (int i = 0; i < array.length; i ++) {
            if (test(array, i) > m)
                m = test(array, i);
        }

        return m;
    }

    public int test(int[] array, int k) {
        if (k == 0 || max[k-1] < 0) {
            max[k] = array[k];
        } else {
            max[k] = max[k-1] + array[k];
        }
        return max[k];
    }

    public static void main(String[] args) {
        NO_42_GreatestSumOfSubArrays test = new NO_42_GreatestSumOfSubArrays();
        int[] data = {1,-2,3,10,-4,7,2,-5};
        System.out.println(test.FindGreatestSumOfSubArray(data));
    }

}
