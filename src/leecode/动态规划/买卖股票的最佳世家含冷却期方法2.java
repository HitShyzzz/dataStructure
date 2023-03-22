package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/15/22:22
 * @Description:
 */
public class 买卖股票的最佳世家含冷却期方法2 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    /**
     * 动态规划：
     * 在方法1的基础上，利用滚动数组的思想，把空间复杂度优化到O(1)；
     * O(T)=O(n);
     * O(S)=O(1);
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int a = -prices[0];
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            int temp = a;
            int temp1 = b;
            a = Math.max(a, c - prices[i]);
            b = temp + prices[i];
            c = Math.max(c, temp1);
        }
        return Math.max(b, c);
    }
}
