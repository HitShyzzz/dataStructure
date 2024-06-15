package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-15 10:17
 */
public class 戳气球方法2 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        int i = maxCoins(nums);
        System.out.println(i);
    }

    // 动态规划
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        val[0] = 1;
        val[n + 1] = 1;
        for (int i = 1; i <= n; i++) val[i] = nums[i - 1];
        // dp[i][j]表示往开区间(i,j)插入气球能获得的最大金币数，dp[0][n+1]就是我们想要的结果
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            // i<j-1，j>i+1
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], val[k] * val[i] * val[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
