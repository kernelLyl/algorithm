import java.util.*;

public class Test {

    public static void main(String[] args) {
        int[] array = {2, 62, 45, 1, 561, 61, 46, 68};
        System.out.println(Arrays.toString(array));
        Test test = new Test();
        test.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    private void quickSort(int[] array, int l, int h) {
        if (l >= h) {
            return;
        }
        int n = partition(array, l, h);
        quickSort(array, l, n - 1);
        quickSort(array, n + 1, h);
    }

    private int partition(int[] array, int l, int h) {
        int temp = array[l];

        while (l < h) {
            while (l < h && array[h] >= temp) {
                h --;
            }
            if (l < h) {
                array[l] = array[h];
            }

            while (l < h && array[l] <= temp) {
                l ++;
            }

            if (l < h) {
                array[h] = array[l];
            }
        }
        array[l] = temp;
        return l;
    }


}
