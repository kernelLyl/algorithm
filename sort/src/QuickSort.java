package src;

import java.util.Arrays;

//快速排序
public class QuickSort {

    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while(left < right) {
            while((right > left) && (arr[right] >= temp)) {
                right --;
            }

            if(right > left) {
                arr[left] = arr[right];
            }


            while((left < right) && (arr[left] <= temp)) {
                left ++;
            }

            if(left < right) {
                arr[right] = arr[left];
            }
        }
        arr[left] = temp;
        return left;
    }


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
}
