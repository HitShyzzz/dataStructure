package leecode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 动态规划，优化状态转移方程
 * O(T)=O(mn)，O(S)=O(mn)
 * @date: 2024-08-15 9:46
 */
public class 矩阵中的最大得分方法2 {
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
        // dp[i][j]=max(max(dp[s][t],0)+grid[i][j]-grid[s][t])=grid[i][j]+max(max(dp[s][t],0)-grid[s][t])
        // 设prerow[i][j]=max(max(dp[i][j],0)-grid[i][j]),那么dp[i][j]=grid[i][j]+prerow[i][j-1](固定i)
        // 同理设precol[i][j]=max(max(dp[i][j],0)-grid[i][j]),那么dp[i][j]=grid[i][j]+precol[i-1][j](固定j)
        int[][] dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        int ans = Integer.MIN_VALUE;
        int[][] preRow = new int[m][n];
        int[][] preCol = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], grid.get(i).get(j) + preRow[i][j - 1]);
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], grid.get(i).get(j) + preCol[i - 1][j]);
                }
                ans = Math.max(dp[i][j], ans);
                preRow[i][j] = preCol[i][j] = Math.max(dp[i][j], 0) - grid.get(i).get(j);
                if (j > 0) {
                    preRow[i][j] = Math.max(preRow[i][j - 1], preRow[i][j]);
                }
                if (i > 0) {
                    preCol[i][j] = Math.max(preCol[i - 1][j], preCol[i][j]);
                }
            }
        }
        return ans;
    }
}
