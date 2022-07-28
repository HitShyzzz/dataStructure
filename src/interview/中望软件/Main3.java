package interview.中望软件;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/28/20:55
 * @Description:
 */
public class Main3 {

    /**
     * 其中grid[i][j]=0表示不能走！
     *
     * @param grid
     * @return 从grid[0][0]到grid[m-1][n-1]的最短时间
     */
    public int shortestTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];// dp[i][j]表示到达grid[i][j]的最短时间！
        // 上面的边界条件
        for (int i = 1; i < n; i++) {
            if (grid[0][i] != 0) {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }
        // 左边的边界条件
        for (int i = 1; i < m; i++) {
            if (grid[i][0] != 0) {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i - 1][j] != 0) {
                    if (grid[i][j - 1] != 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                } else {
                    if (grid[i][j - 1] != 0) {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
