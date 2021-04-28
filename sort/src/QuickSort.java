import java.util.Arrays;
import java.util.Random;

//快速排序
public class QuickSort {

    private static Random random = new Random(System.currentTimeMillis());

    public static int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];

        // 将等于 pivot 的元素分散到两边
        // [left, lt) <= pivot
        // (rt, right] >= pivot

        int lt = left + 1;
        int rt = right;

        while (true) {
            //当跳出while循环时,lt指的是大于pivot的
            while (lt <= rt && nums[lt] <= pivot) {
                lt++;
            }
            //当跳出while循环时,rt指的是小于pivot的
            while (lt <= rt && nums[rt] >= pivot) {
                rt--;
            }

            if (lt > rt) {
                break;
            }
            swap(nums, lt, rt);
            lt++;
            rt--;
        }

        swap(nums, left, rt);
        return rt;
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
