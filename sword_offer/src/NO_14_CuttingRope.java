public class NO_14_CuttingRope {
    public static int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] value = new int[61];
        value[1] = 1;
        value[2] = 2;
        value[3] = 3;
        for(int i = 4; i <= target; i ++) {
            int max = 0, product = 0;
            for(int j = 1; j < i; j ++) {
                product = value[j] * value[i - j];
                if(product > max) {
                    max = product;
                }
            }
            value[i] = max;
        }
        return value[target];
    }

    public static void main(String[] args) {

    }
}
