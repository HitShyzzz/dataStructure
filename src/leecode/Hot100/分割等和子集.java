package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-04 20:58
 */
public class 分割等和子集 {
    public static void main(String[] args) {
        //int[] nums = {14, 9, 8, 4, 3, 2};
        int[] nums = {1, 5, 11, 5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }

    // 输入：nums = [1,5,11,5]
    // 输出：true
    // 解释：数组可以分割成 [1, 5, 5] 和 [11]
    /**
     * @description: dp[i][j]表示s[0,i]是否存在元素使得这些元素之和为j
     * @return:
     **/
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] == j) dp[i][j] = true;
                else if (nums[i - 1] < j) dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
            if (dp[i][target]) return true;
        }
        return false;
    }
}