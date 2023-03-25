package leecode.动态规划;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/15/23:10
 * @Description:
 */
public class 戳气球 {
    // 记忆化搜索，利用solve数组来记录中间结果，避免重复计算！
    private static int[][] solve;

    public static void main(String[] args) {
        int[] nums = {8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5};
        int i = maxCoins(nums);
        System.out.println(i);
    }

    /**
     * O(T)=O(n^3),总共有n^2个区间，每个区间需要填充n次，总共时间复杂度就是O(n^3);
     * O(S)=O(n^2);
     *
     * @param nums
     * @return
     */
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        // 这样重新定义val数组只是为了方便处理边界条件
        int[] val = new int[n + 2];
        val[0] = 1;
        val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        solve = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(solve[i], -1);
        }
        return recur(val, 0, n + 1);
    }

    /**
     * @param val
     * @param i
     * @param j
     * @return 填充区间(i, j)所能获得的最大的硬币数；
     */
    public static int recur(int[] val, int i, int j) {
        if (i >= j - 1) {
            return 0;
        }
        if (solve[i][j] != -1) {
            return solve[i][j];
        }
        for (int mid = i + 1; mid < j; mid++) {
            solve[i][j] = Math.max(solve[i][j], recur(val, i, mid) + recur(val, mid, j) + val[i] * val[mid] * val[j]);
        }
        return solve[i][j];
    }
}
