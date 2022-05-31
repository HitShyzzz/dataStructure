package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/17/23:41
 * @Description:
 */
public class BestSituationBuyStack {
    // 动态规划
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = 0;// 不持有股票，且没卖出的。
        dp[0][1] = 0;// 不持有股票，且今天卖出。
        dp[0][2] = -1 * prices[0];// 持有股票且今天买入
        dp[0][3] = -1 * prices[0];// 持有股票且今天没买入
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);// 不持有包括dp[i][0],dp[i][1]两种状态！
            dp[i][1] = Math.max(dp[i - 1][2] + prices[i], dp[i - 1][3] + prices[i]);// 今天想卖出必须得先持有！
            dp[i][2] = dp[i - 1][0] - prices[i];// 今天想买入，前一天必须不能卖出！冷冻期,买入手里必须没有股票！
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2]);// 今天没买却持有股票，包括昨天没买，昨天买了两种情况。
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
