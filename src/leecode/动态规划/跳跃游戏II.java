package leecode.动态规划;

import javax.swing.text.MaskFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/25/18:02
 * @Description:
 */
public class 跳跃游戏II {
    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        int b = jump(nums);
        System.out.println(b);
    }

    /**
     * 动态规划，dp[i]表示到达i位置的最短跳跃次数，需要返回dp[n-1];
     * 那么对于dp[i]我们需要找到能所有能一步从j位置到达i位置中的dp[j]的最小值，我们的dp[i]=min(dp[j])+1;
     * O(T)=O(n^2);两重for循环；
     * O(S)=O(1);
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int n = nums.length;
        // dp[i]表示从0位置到达下标i位置的最短距离!我们需要返回dp[n-1];
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                // 你必须能从j到达i位置，才有资格来更新i位置的dp[i]
                if (nums[j] >= i - j) {
                    min = Math.min(min, dp[j]);
                }
                dp[i] = min + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
        return dp[n - 1];
    }
}
