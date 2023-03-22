package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/06/22:50
 * @Description:
 */
public class 买卖股票的最佳时机方法3 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }

    /**
     * 利用滚动数组的思想把动态规划的空间复杂度优化到O(1);
     * O(T)=O(n);
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int profit = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}
