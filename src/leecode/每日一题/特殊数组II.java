package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 暴力一一判断，果然超时！
 * @date: 2024-08-14 9:44
 */
public class 特殊数组II {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = queries.length;
        boolean[] ans = new boolean[n];
        for (int i = 0; i < n; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            ans[i] = check(nums, from, to);
        }
        return ans;
    }

    public boolean check(int[] nums, int i, int j) {
        for (int k = i; k <= j; k++) {
            if (k > i && (nums[k] + nums[k - 1]) % 2 == 0) return false;
        }
        return true;
    }
}
