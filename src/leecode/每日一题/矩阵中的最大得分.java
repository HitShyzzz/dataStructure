package leecode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 动态规划，暴力计算，超时！
 * @date: 2024-08-15 9:46
 */
public class 矩阵中的最大得分 {
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>(List.of(List.of(9, 5, 7, 3), List.of(8, 9, 6, 1), List.of(6, 7, 14, 3), List.of(2, 5, 3, 1)));
        int i = maxScore(grid);
        System.out.println(i);
    }

    // 输入：grid = [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]
    //
    // 输出：9
    public static int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        // dp[i][j]表示到达grid[i][j]能获得的累积最大积分
        int[][] dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        int ans = Integer.MIN_VALUE;
        for (int j = 1; j < n; j++) {
            for (int k = 0; k < j; k++) {
                dp[0][j] = Math.max(dp[0][j], Math.max(dp[0][k], 0) + grid.get(0).get(j) - grid.get(0).get(k));
                ans = Math.max(ans, dp[0][j]);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int k = 0; k < i; k++) {
                dp[i][0] = Math.max(dp[i][0], Math.max(dp[k][0], 0) + grid.get(i).get(0) - grid.get(k).get(0));
                ans = Math.max(ans, dp[i][0]);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int s = 0; s <= i; s++) {
                    for (int t = 0; t <= j; t++) {
                        if (s == i && t == j) {
                            continue;
                        }
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[s][t], 0) + grid.get(i).get(j) - grid.get(s).get(t));
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }
        return ans;
    }
}
