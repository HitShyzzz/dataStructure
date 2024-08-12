package leecode.动态规划;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 动态规划
 * @date: 2024-08-12 21:50
 */
public class 丑数II方法2 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(11));
    }

    public static int nthUglyNumber(int n) {
        // dp[i]表示第i个丑数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // p2,p3,p5三个指针分别表示当前指针指向的丑数乘以2，3，5
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n];
    }
}
