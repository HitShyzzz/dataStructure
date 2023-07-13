package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/07/13/15:53
 * @Description:
 */
public class 下降路径最小和 {
    // 动态规划
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.min(j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE, Math.min(j + 1 < n ? dp[i - 1][j + 1] : Integer.MAX_VALUE, dp[i - 1][j])) + matrix[i][j];
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[m - 1][j]);
        }
        return minSum;
    }
}
