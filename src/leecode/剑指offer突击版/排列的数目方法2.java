package leecode.剑指offer突击版;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/07/16/13:28
 * @Description:
 */
public class 排列的数目方法2 {


    // 输入：nums = [1,2,3], target = 4
    // 输出：7
    // 解释：
    // 所有可能的组合为：
    // (1, 1, 1, 1)
    // (1, 1, 2)
    // (1, 2, 1)
    // (1, 3)
    // (2, 1, 1)
    // (2, 2)
    // (3, 1)
    //请注意，顺序不同的序列被视作不同的组合。
    // 动态规划
    public int combinationSum4(int[] nums, int target) {
        // dp[i]表示选取元素之和为i的方案数，我们要的是dp[target]
        int[] dp = new int[target + 1];
        dp[0] = 1;// 什么都不选也是1种方案，也是方便后面状态转移方程的处理
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];// dp[i]是所有的dp[i-num]之和
                }
            }
        }
        return dp[target];
    }
}
