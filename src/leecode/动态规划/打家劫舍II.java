package leecode.动态规划;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-12 20:30
 */
public class 打家劫舍II {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int rob = rob(nums);
        System.out.println(rob);
    }

    // 输入：nums = [1,2,3,1]
    // 输出：4
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return nums[0];
        // 如果选择了nums[0]，那不能偷nums[1]和nums[n-1]，就变成了在[2,n-2]范围内找最大值
        // 如果不选择偷nums[0]，那就变成在[1.n-1]范围内找最大值
        // 两种情况取最大值即可
        return Math.max(solve(nums, 0, n - 2), solve(nums, 1, n - 1));
    }

    public static int solve(int[] nums, int start, int end) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[start] = nums[start];
        for (int i = start; i <= end; i++) {
            if (i == 0) {
                continue;
            }
            dp[i] = Math.max(dp[i - 1], (i - 2 >= 0 ? dp[i - 2] : 0) + nums[i]);
        }
        return dp[end];
    }
}
