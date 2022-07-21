package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/22/0:21
 * @Description:
 */
public class 目标和方法3 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int ways = findTargetSumWays(nums, target);
        System.out.println(ways);
    }

    /**
     * 利用滚动数组的思路把空间复杂度优化到O(neg);
     * O(T)=O(n*neg);
     * O(S)=O(neg);
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // sum-target必须得是非负偶数
        if (sum - target < 0 || (sum - target) % 2 != 0) {
            return 0;
        }
        int n = nums.length;
        int neg = (sum - target) / 2;
        int[] dp = new int[neg + 1];
        // dp[0][0]表示没有添加元素和为0，没有添加元素和自然为0，因此dp[0][0]=1;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = neg; j >= nums[i - 1]; j--) {
                dp[j] = dp[j - nums[i - 1]] + dp[j];
            }
        }
        return dp[neg];
    }
}
