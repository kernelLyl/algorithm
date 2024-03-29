import java.util.Arrays;
import java.util.Random;

//快速排序
public class QuickSort {

    private static Random random = new Random(System.currentTimeMillis());

    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        int lt = left;
        while (left <= right) {
            while (left <= right && arr[left] <= temp) {
                left ++;
            }
            while (left <= right && arr[right] >= temp) {
                right --;
            }
            if (left < right) {
                swap(arr, left, right);
                left ++;
                right --;
            }
            if (left > right) {
                swap(arr, lt, right);
            }
        }
        return right;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    /**
     * 1. 先从数列中取出一个数作为基准数
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边
     * 3．再对左右区间重复第二步，直到各区间只有一个数
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return ;
        }
        int n = partition(arr, left, right);
        quickSort(arr, left, n-1);
        quickSort(arr, n+1, right);
    }

    public static void main(String[] args) {
        int[] a = {2, 62, 45, 1, 561, 61, 46, 6,6,6,7,7,8};
        quickSort(a, 0, (a.length - 1));
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int n = partition1(arr, left, right);
        quickSort1(arr, left, n - 1);
        quickSort1(arr, n + 1, right);
    }

    public static int partition1(int[] arr, int left, int right) {
        if (left >= right) {
            return left;
        }

        int temp = arr[left];

        while (left < right) {
            while(left < right && arr[right] >= temp) {
                right --;
            }

            if (left < right) {
                arr[left] = arr[right];
            }

            while (left < right && arr[left] <= temp) {
                left ++;
            }

            if (left < right) {
                arr[right] = arr[left];
            }
        }
        arr[left] = temp;
        return left;
    }



































}
