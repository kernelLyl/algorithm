public class NO_215_FindKthLargest {
    public static void main(String[] args) {
//        int[] tree = {7, 8, 1, 11, 4, 10, 3, 5, 1, 2};
//        int n = 10;
//        buildHeap(tree, n);
//        int i = 0;
//        for (i = 0; i < n; i ++) {
//            System.out.println(tree[i]);
//        }
        int[] tree = {3,2,1,5,6,4};
        findKthLargest(tree, 2);
    }

    public static int findKthLargest(int[] nums, int k) {
        buildHeap(nums, k);
        for (int i = k; i < nums.length; i ++) {
            if (nums[i] > nums[0]) {
                swap(nums, i, 0);
                heapify(nums, k, 0);
            }
        }
        return nums[0];
    }

    public static void buildHeap(int tree[], int n) {
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;
        for (int i = parent; i >= 0; i --) {
            heapify(tree, n, i);
        }
    }

    /**
     *
     * @param tree
     * @param n 堆有多少个节点
     * @param i 对第i个节点做heapify
     */
    public static void heapify(int[] tree, int n, int i) {
        if (i >= n) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && tree[c1] < tree[max]) {
            max = c1;
        }
        if (c2 < n && tree[c2] < tree[max]) {
            max = c2;
        }
        if (max != i) {
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }

    private static void swap(int[] tree, int fpos, int spos)
    {
        int tmp;
        tmp = tree[fpos];
        tree[fpos] = tree[spos];
        tree[spos] = tmp;
    }

}
