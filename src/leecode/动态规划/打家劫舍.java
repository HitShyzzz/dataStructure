package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/10/19:49
 * @Description:
 */
public class 打家劫舍 {
    /**
     * 动态规划，设dp[i]表示[0,i]区间内能偷到的最大金额，我们需要返回dp[n];
     * 对于dp[i]有两种情况：如果偷了nums[i],那么dp[i]=dp[i-2]+nums[i];如果没偷nums[i],dp[i]=dp[i-1];
     * dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
     * O(T)=O(n)
     * O(S)=O(n)
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
