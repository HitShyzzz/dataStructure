package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-15 16:29
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    // 输入：nums = [10,9,2,5,3,7,101,18]
    // 输出：4
    // 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }
}
