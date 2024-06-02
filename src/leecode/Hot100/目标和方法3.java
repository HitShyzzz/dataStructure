package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-02 11:36
 */
public class 目标和方法3 {
    public static void main(String[] args) {
        int[] nums = {1, 0};
        int target = 1;
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
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = neg; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[neg];
    }
}
