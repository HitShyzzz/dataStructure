package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-15 22:34
 */
public class 完全平方数 {
    public static void main(String[] args) {
        int n = 12;
        int i = numSquares(n);
        System.out.println(i);
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int sup = (int) Math.sqrt(i);
            for (int j = 1; j <= sup; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
