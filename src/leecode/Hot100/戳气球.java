package leecode.Hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Spliterator;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-15 10:17
 */
public class 戳气球 {
    int[][] solve;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        val[0] = 1;
        val[n + 1] = 1;
        solve = new int[n + 2][n + 2];
        for (int[] ints : solve) {
            Arrays.fill(ints, -1);
        }
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        return dfs(val, 0, n + 1);
    }

    // 逆向思维，考虑往开区间(i,j)内插入气球k，计算气球k对开区间（i，j）的贡献
    // val[i,j]插入气球能获得的最大金币数
    public int dfs(int[] val, int i, int j) {

        if (i < 0 || j == val.length || i >= j - 1) return 0;
        // 保存中间结果，避免重复计算
        if (solve[i][j] != -1) return solve[i][j];
        int res = 0;
        for (int k = i + 1; k < j; k++) {
            res = Math.max(res, val[k] * val[i] * val[j] + dfs(val, i, k) + dfs(val, k, j));
            solve[i][j] = res;
        }
        return solve[i][j];
    }
}
