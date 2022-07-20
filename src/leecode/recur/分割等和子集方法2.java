package leecode.recur;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/20/20:53
 * @Description:
 */
public class 分割等和子集方法2 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }

    /**
     * 动态规划；设dp[i][j]表示能否从区间[0,i]中找出一些元素使得他们的和为j;
     * 那么if不选择Nums[i],dp[i][j]=dp[i-1][j];
     * if 选择nums[i],dp[i][j]=dp[i-1][j-nums[i]];(nums[i]<=j);
     * 最后返回dp[n-1][target];
     * O(T)=O(n*target);
     * O(S)=O(n*target);target=sum/2;
     *
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 != 0 || max > sum / 2) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                // 选择nums[i]
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i]];
                } else {// 不选择nums[i]
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

}
