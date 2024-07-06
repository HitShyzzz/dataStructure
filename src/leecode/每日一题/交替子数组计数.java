package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: dp，O(S)=O(N)
 * @date: 2024-07-06 12:18
 */
public class 交替子数组计数 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0};
        long l = countAlternatingSubarrays(nums);
        System.out.println(l);
    }

    // 输入： nums = [1,0,1,0]
    // 输出： 10
    public static long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        // dp[i]表示以nums[i]结尾的交替子数组个数
        int[] dp = new int[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            if (i > 0 && nums[i] != nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            ans += dp[i];
        }
        return ans;
    }
}

