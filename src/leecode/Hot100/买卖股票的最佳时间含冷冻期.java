package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-15 11:30
 */
public class 买卖股票的最佳时间含冷冻期 {
    public static void main(String[] args) {
        int[] prices = {2, 1};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    // 输入: prices = [1,2,3,0,2]
    // 输出: 3
    // 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]表示第i天持有股票获得的最大利润
        // dp[i][1]表示第i天不持有股票，且处于冷冻期（第i天进行了卖出操作）获得的最大利润
        // dp[i][2]表示第i天不持有股票，且不处于冷冻期（第i天未进行任何操作）获得的最大利润
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
