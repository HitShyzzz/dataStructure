package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/26/15:11
 * @Description: 分割等和子集转化成能否从数组中挑选出元素使得这些元素的和是数组所有元素和的一半！转化成了0-1背包问题！
 * 这个思路太秒了！
 */
public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = 0;// 用来记录数组所有元素的和
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {// 所有元素和为奇数，必然不能找到元素和是sum的一半！
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];// target+1是为了容量为0的情况
        if (nums[0] <= target) {// target为它自己，只好由它自己去充满；
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];// 不选择nums[i],则就看[0,i-1]区间能否找到这些元素！
                // 选择nums[i]
                if (j == nums[i]) {// dp[i][j]表示能否从[0,i]区间挑选出一些元素，使得这些元素的和恰好为j;
                    dp[i][j] = true;
                } else if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            if (dp[i][target] == true) {
                return true;
            }
        }
        return dp[n - 1][target];
    }
}
