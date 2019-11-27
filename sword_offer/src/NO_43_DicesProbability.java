import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//把 n 个骰子仍在地上，所有骰子朝上一面的点数之和为 s。输入 n，打印出 s 的所有可能的值出现的概率
//用动态规划
//设扔 n 个骰子时排列数之和为 s 的函数为f(n,s)
//f(n,s)=f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6),n<=s<=6n
//f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1
public class NO_43_DicesProbability {
    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= face; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = i; j <= face * i; j++)     /* 使用 i 个骰子最小点数为 i */
                for (int k = 1; k <= face && k <= j; k++) //第n个色子的6种情况
                    dp[i][j] += dp[i - 1][j - k];

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(dicesSum(10));
    }
}
