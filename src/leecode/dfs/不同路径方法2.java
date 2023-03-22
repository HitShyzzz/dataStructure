package leecode.dfs;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/15:49
 * @Description:
 */
public class 不同路径方法2 {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int paths = uniquePaths(m, n);
        System.out.println(paths);
    }

    /**
     * 动态规划来减少空间复杂度，设dp[i][j]表示到达m[i][j]位置的所有路径之和，
     * 那么dp[i][j]=dp[i-1][j]+dp[i][j-1];
     * 把边界条件处理一下就没啥细节了；
     * O(T)=O(mn);
     * O(S)=O(mn);
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        // 初始化上边界
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        // 初始化左边界
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
