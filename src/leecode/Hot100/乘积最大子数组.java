package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-17 22:03
 */
public class 乘积最大子数组 {
    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        int i = maxProduct(nums);
        System.out.println(i);
    }

    // 输入: nums = [-2,3,-4]
    // 输出: 24
    // 解释: 子数组 [2,3] 有最大乘积 6。
    // O(S)=O(N)
    public static int maxProduct(int[] nums) {
        int ans = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // dp[i][0]表示以nums[i]结尾的最大乘积子数组，
            // dp[i][1]表示以nums[i]结尾的最小乘积子数组
            // dp[i][0]=max(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i],nums[i])三者的最大值，因为会出现一个负数乘以负数为正数的情况
            // dp[i][1]=min(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i],nums[i])三者的最大值，因为会出现一个正数乘以负数为负数的情况
            dp[i][0] = Math.max(Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }
}
