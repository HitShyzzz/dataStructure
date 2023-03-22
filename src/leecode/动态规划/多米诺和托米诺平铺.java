package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/12/10:00
 * @Description:
 */
public class 多米诺和托米诺平铺 {
    int mod = 1000000007;

    public int numTilings(int n) {
        // dp[i][s]表示铺到第i列第S个状态的不同铺发=法数量，
        // dp[i][0]表示第i列上下都不覆盖的正方形的不同铺法数量，
        // dp[i][1]表示第i列只覆盖上面的正方形的不同铺法数量，
        // dp[i][2]表示第i列只覆盖下面的正方形的不同铺法数量，
        // dp[i][3]表示第i列上面下面正方形都要覆盖的不同铺法数量，
        int[][] dp = new int[n + 1][4];
        dp[0][3] = 1;// 这里想想dp[i][0]=dp[i-1][3]!
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % mod + dp[i - 1][2]) % mod + dp[i - 1][3]) % mod;
        }
        return (dp[n][3]) % mod;
    }
}
