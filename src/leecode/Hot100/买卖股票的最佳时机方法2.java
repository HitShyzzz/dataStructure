package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 滚动数组，O(S)减少为O(1)
 * @date: 2024-06-25 21:29
 */
public class 买卖股票的最佳时机方法2 {
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
        int higher = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            higher = Math.max(higher, prices[i]);
            ans = Math.max(ans, higher - prices[i]);
        }
        return ans;
    }
}
