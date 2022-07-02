package leecode.dfs;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/16:18
 * @Description:
 */
public class 最小路径和方法2 {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        //int[][]grid={{1,2,3},{4,5,6}};
        int pathSum = minPathSum(grid);
        System.out.println(pathSum);
    }

    /**
     * 动态规划来优化时间复杂度!
     * 设dp[i][j]为到达grid[i][j]的最小路径和，则dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
     * 同样还是处理一下上边界和左边界就好了！
     * O(T)=O(mn);
     * O(S)=O(mn);
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 初始化上边界
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 初始化左边界
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
