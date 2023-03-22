package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/14/19:58
 * @Description:
 */
public class 完全平方数 {
    public static void main(String[] args) {
        int n=13;
        int i = numSquares(n);
        System.out.println(i);
    }
    /**
     * 动态规划，设dp[i]表示i的最少完全平方数，那么dp[i]=Math.min(i-j*j)+1;j=1,...Math.sqrt(n);
     *O(T)=O(n*n^1/2),
     * O(S)=O(n);
     *
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = n;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
