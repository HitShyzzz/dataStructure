package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/25/17:25
 * @Description:
 */
public class 跳跃游戏 {

    /**
     * 判断能否到达最后一个位置，动态规划；
     * dp[i]表示能否从0位置到达下标i的位置；我们需要返回dp[n-1];
     * 那么如果从j=0,...i-1,满足首先能到达dp[j]然后Nums[j]>=j-i,那么就表示能从j位置到达i位置！
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}
