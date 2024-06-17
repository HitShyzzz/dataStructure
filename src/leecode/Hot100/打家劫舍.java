package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-17 20:42
 */
public class 打家劫舍 {
    // 输入：[2,7,9,3,1]
    // 输出：12
    // 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
    // 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max((i - 2 >= 0 ? dp[i - 2] : 0) + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
