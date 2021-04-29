public class HeapSort {

    public static void main(String[] args) {
        int[] tree = {7, 8, 1, 11, 4, 10, 3, 5, 1, 2};
        int n = 10;
        heapSort(tree, n);
        int i = 0;
        for (i = 0; i < n; i ++) {
            System.out.println(tree[i]);
        }
    }

    public static void heapSort(int[] tree, int n) {
        buildHeap(tree, n);
        for (int i = n - 1; i > 0; i --) {
            swap(tree, 0, i);
            heapify(tree, i, 0);
        }
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
