package leecode.Hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.concurrent.ForkJoinTask;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: O(T)=O(N),O(S)=O(N)
 * @date: 2024-06-25 21:29
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    // 输入：[7,1,5,3,6,4]
    // 输出：5
    // 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    // 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
    public static int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        // dp[i]表示高于第i天的最大股票价格
        int[] dp = new int[n];
        dp[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], prices[i]);
            ans = Math.max(ans, dp[i] - prices[i]);
        }
        return ans;
    }
}
