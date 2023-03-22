package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/21/23:25
 * @Description:
 */
public class 目标和方法2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        int ways = findTargetSumWays(nums, target);
        System.out.println(ways);
    }

    /**
     * 动态规划，用空间换取时间！如果直接设dp[i.j]表示在区间[0,i]找一些元素使得这些元素之和为j的方案数字，那么需要返回的是
     * dp[n][target],但这样因为每个元素可以添加负号，这样在计算dp[i][j]的时候就会涉及到dp[i-1][j+nums[i]],
     * 而dp[i-1][j+nums[i]]这一项是后面才会出现的，不符合动态规划的思想，因此这样做不行！必须把加负号的先拿出来考虑！
     * 设数组所有元素之和是sum，添加符号的元素之和是neg,那么添加正号的元素之和是sum-neg,因此有sum-neg-neg=target,则
     * neg=(sum-target)/2;因此sum-target必须得是非负偶数！设dp[i][j]表示在区间[0,i]内找一些元素之和为j的方案数，
     * 我们返回dp[n][neg]就行了!
     * O(T)=O(n*neg);
     * O(S)=O(n*neg);
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
        int[][] dp = new int[n + 1][neg + 1];
        // dp[0][0]表示没有添加元素和为0，没有添加元素和自然为0，因此dp[0][0]=1;
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= neg; j++) {
                //j<nums[i],则不能添加nums[i]
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {// j>=nums[i],则可以添加nums[i],也可以不添加nums[i]
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[n][neg];
    }
}
