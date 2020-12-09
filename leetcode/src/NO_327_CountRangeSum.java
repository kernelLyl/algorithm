public class NO_327_CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        //前驱和数组+归并排序 Nlog(N)
        long[] preSum = new long[nums.length + 1];  //nums[i]=preSum[i+1]-preSum[i] 所以前驱和长度多1
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }
        return mergesort(preSum, 0, preSum.length - 1, lower, upper);
    }

    public int mergesort(long[] arr, int left, int right, int lower, int upper) {
        //归并分而治之，拆分待排序数据，递归实现
        if (left == right) return 0;
        int mid = (left + right) / 2;
        int resLeft = mergesort(arr, left, mid, lower, upper);
        int resRight = mergesort(arr, mid + 1, right, lower, upper);
        int res = resLeft + resRight;

        //统计当前待合并数组间的区间和个数，每一个右边元素减去每一个左边元素（表示一段区间和)
        //转化为两升序数组之间的差在某一区间的问题，维护i指向arr1，l和r指向arr2
        //让l和r分别指向与i的差在区间边界的情况，再统计个数即可,主要是为了降低时间复杂度！
        //[l,r)都符合条件
        int i = left;
        int l = mid + 1;
        int r = mid + 1;
        while (i <= mid) {
            while (l <= right && arr[l] - arr[i] < lower) {
                l++;
            }
            while (r <= right && arr[r] - arr[i] <= upper) {
                r++;
            }
            res += r - l;
            i++;
        }

        //归并，使用传统方法，维护i和j两个变量即可
        long[] temp = new long[right - left + 1];
        int t = 0;
        i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[t++] = arr[i++];
            else temp[t++] = arr[j++];
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (t < temp.length) {
            arr[left++] = temp[t++];
        }

        return res;  //返回当前节点满足条件的区间和个数
    }

}
