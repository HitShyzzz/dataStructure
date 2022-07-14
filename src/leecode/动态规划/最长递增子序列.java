package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/14/22:32
 * @Description:
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    /**
     * 动态规划，设dp[i]表示以nums[i]结尾的最长递增子序列的长度，那么dp[i]=max(dp[j])+1,其中j=0,1,...i-1,还要满足
     * nums[j]<nums[i],如果没有j=0,1,...i-1满足nums[j]<nums[i]，那么dp[i]=1;
     * O(T)=O(n^2);
     * O(S)=O(n);
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                    dp[i] = max + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
