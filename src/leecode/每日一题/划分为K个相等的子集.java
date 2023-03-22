package leecode.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/20/19:45
 * @Description:
 */
public class 划分为K个相等的子集 {
    // 状态压缩+记忆化搜索
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        if (nums[n - 1] > target) {
            return false;
        }
        Arrays.sort(nums);
        boolean[] dp = new boolean[1 << n];
        Arrays.fill(dp, true);
        return dfs((1 << n) - 1, nums, target, 0, dp);

    }

    /**
     * @param state  状态S
     * @param nums
     * @param target
     * @param curSum 当前已经加的和，如果刚好curSum==target,那么就把curSum设为0；
     * @param dp     dp[i]表示第i个状态S是否可用，初始时都是可用的，设为true；
     * @return
     */
    public boolean dfs(int state, int[] nums, int target, int curSum, boolean[] dp) {
        if (state == 0) {
            return true;
        }
        // dp[state]为false，表示state这个状态已经用过了，就直接返回dp[state]的值就行了；
        if (!dp[state]) {
            return dp[state];
        }
        // 表示使用state这个状态
        dp[state] = false;
        for (int i = 0; i < nums.length; i++) {
            // 已经从小到大排序了，如果当前元素已经超了，就没必要再看了。
            if (nums[i] + curSum > target) {
                break;
            }
            // 第i个状态没用过
            if (((state >> i) & 1) != 0) {
                // 状态S是从后往前移动i位，1<<i是从后往前移动i位，异或起来就表示把每一位的状态都考虑进去了
                // 如果把每一位状态都考虑进去还是true的话，说明当前方案就是可行的！
                // curSum+nums[i]%target,是说当curSum+nums[i]==target时，curSum自动就转化为0了。
                if (dfs(state ^ (1 << i), nums, target, (curSum + nums[i]) % target, dp)) {
                    return true;
                }
            }
        }
        return false;
    }
}
