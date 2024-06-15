package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-15 11:30
 */
public class 买卖股票的最佳时间含冷冻期方法2 {
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
        int a = -prices[0];
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            int preA = a;
            a = Math.max(a, c - prices[i]);
            int preB = b;
            b = preA + prices[i];
            c = Math.max(preB, c);
        }
        return Math.max(b, c);
    }
}
