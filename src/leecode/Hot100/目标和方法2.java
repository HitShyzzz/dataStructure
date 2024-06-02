package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-02 11:36
 */
public class 目标和方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int targetSumWays = findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }

    // 输入：nums = [1,1,1,1,1], target = 3
    //  输出：5
    //  解释：一共有 5 种方法让最终目标和为 3 。
    //-1 + 1 + 1 + 1 + 1 = 3
    //+1 - 1 + 1 + 1 + 1 = 3
    //+1 + 1 - 1 + 1 + 1 = 3
    //+1 + 1 + 1 - 1 + 1 = 3
    //+1 + 1 + 1 + 1 - 1 = 3
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target || (sum - target) % 2 != 0) {
            return 0;
        }
        int neg = (sum - target) / 2;
        int n = nums.length;
        // dp[i][j]表示前i个元素之和为j的不同方案数
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= neg; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[n][neg];
    }
}
