package leecode.每日一题;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 动态规划
 * @date: 2024-08-14 9:44
 */
public class 特殊数组II方法2 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 2, 6};
        int[][] queries = {{0, 4}};
        boolean[] arraySpecial = isArraySpecial(nums, queries);
        System.out.println(Arrays.toString(arraySpecial));
    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = queries.length;
        boolean[] ans = new boolean[n];
        int m = nums.length;
        // dp[i]表示以nums[i]结尾的最长特殊子数组长度
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            // nums[i]和nums[i-1]奇偶性不同，则dp[i]=dp[i-1]+1
            // 否则dp[i]=1
            if ((nums[i] + nums[i - 1]) % 2 != 0) dp[i] = dp[i - 1] + 1;
        }
        for (int i = 0; i < n; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            // 如果[i,j]区间是特殊子数组，那么[i.j]的任意子串都是特殊子数组
            // 因此只需要判断以to结尾的最长特殊子数组长度能否覆盖[from,to]区间的长度
            if (dp[to] >= to- from + 1) ans[i] = true;
        }
        return ans;
    }
}
