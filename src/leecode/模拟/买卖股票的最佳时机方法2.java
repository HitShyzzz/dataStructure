package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/06/22:33
 * @Description:
 */
public class 买卖股票的最佳时机方法2 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }
    /**
     * 动态规划，设dp[i]表示在第i天之前买入的最小值，那么第i天卖出的最大获利就是prices[i]-dp[i],我们需要返回最大的
     * prices[i]-dp[i]；
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = prices[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            // 如果prices[i]是最小的，那么就是当天买入当天卖出，获利还是0；
            dp[i] = Math.min(dp[i - 1], prices[i]);
            profit = Math.max(profit, prices[i] - dp[i]);
        }
        return profit;
    }
}
