public class NO_39_MoreThanHalfNumber {
    public int MoreThanHalfNum_Solution(int [] array) {
        int current = 0; //初始值0
        int count = 0;   //初始值0

        for(int i=0;i<array.length;i++){   //遍历数组
            if(count==0)       //如果count为0，代表前面的数字正好全部抵消了
            {
                current = array[i];  //current重新设定为当前遍历到的值
                count = 1;
            }
            else
            {
                if(array[i]==current)  //current等于当前遍历到的值 count++
                    count++;
                else  				//current不等于当前遍历到的值 抵消 count--
                    count--;
            }

        }

        //最后
        int times = 0;
        for(int i = 0; i < array.length; i ++) {
            if(array[i] == current)
                times ++;
        }

        if(times * 2 <= array.length)
            return 0;

        return current;   //最后current中存储的就是出现次数超过⌊n/2⌋的数字
    }

    public static int MoreThanHalfNum_Solution_Partition(int[] array) {

        int left = 0, right = array.length - 1;
        int half = array.length / 2;
        int index;
        while ((index = partition(array, left, right)) != half) {
            if  (index > half) {
                right = index - 1;
            }
            if  (index < half) {
                left = index + 1;
            }
        }

        int mid = array[index], count = 0;


        for (int i = 0;  i < array.length; i ++) {
            if (array[i] == mid) {
                count ++;
            }
        }

        if (count > half) {
            return mid;
        }

        return 0;
    }

    public static int partition(int[] array, int left , int right) {
        int temp = array[left];

        while (left < right) {
            while ((left < right) && (array[right] >= temp)) {
                right --;
            }

            if (left < right) {
                array[left] = array[right];
            }

            while ((left < right) && (array[left] <= temp)) {
                left ++;
            }

            if  (left < right) {
                array[right] = array[left];
            }
        }

        array[left] = temp;
        return left;
    }

    public static void main(String[] args) {
//        int[] a = {55, 2, 3, 50, 2, 3, 2, 2, 2, 2};
        int[] a = {1};
        int b = MoreThanHalfNum_Solution_Partition(a);
        System.out.println(b);
    }
}
