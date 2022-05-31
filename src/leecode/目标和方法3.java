package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/02/11:13
 * @Description:
 */
public class 目标和方法3 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum - target < 0 || ((sum - target) % 2 != 0)) {
            return 0;
        }
        int neg = (sum - target) / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            for (int j = neg; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] += dp[j - nums[i - 1]];
                }
            }
        }
        return dp[neg];
    }
}
