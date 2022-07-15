package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/15/21:35
 * @Description:
 */
public class 买卖股票的最佳时机含冷冻期 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    /**
     * 动态规划：
     * 设f[i]表示第i天结束之后的累计收益，那么对于第i天结束之后有三种状态：
     * ①持有股票，记为f[i][0];
     * ②不持有股票，且处于冷冻期，记为f[i][1];
     * ③不持有股票，不处于冷冻期，记为f[i][2];
     * 那么f[i][0]=Math.max(f[i-1][0],f[i-1][2]-prices[i]);
     * f[i][1]=f[i-1][0]+prices[i];
     * f[i][2]=Math.max(f[i-1][2],f[i-1][1]);
     * 我们需要返回的是Math.max(f[n-1][1],f[n-1][2]);最后一天还持有股票肯定没有不持有股票累计收益高
     * O(T)=O(n);
     * O(S)=O(n);
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][2], f[i - 1][1]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}
