public class NO_46_Accumulate {

    //利用递归做累加,并通过&&逻辑运算符实现判断
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
