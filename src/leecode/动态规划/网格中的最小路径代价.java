package leecode.动态规划;
import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-11-22 20:18
 */
public class 网格中的最小路径代价 {
    public static void main(String[] args) {
        int[][] grid = {{5, 3}, {4, 0}, {2, 1}};
        int[][] moveCost = {{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        int i = minPathCost(grid, moveCost);
        System.out.println(i);
    }

    // 输入：grid = [[5,3],[4,0],[2,1]], moveCost = [[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]
    // 输出：17
    // 解释：最小代价的路径是 5 -> 0 -> 1 。
    //- 路径途经单元格值之和 5 + 0 + 1 = 6 。
    //- 从 5 移动到 0 的代价为 3 。
    //- 从 0 移动到 1 的代价为 8 。
    //路径总代价为 6 + 3 + 8 = 17 。
    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int minCost = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        // 最后一行值移动代价都是0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moveCost[grid[m - 1][i]][j] = 0;
            }
        }
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, dp[m - 1][i]);
        }
        return minCost;
    }
}
