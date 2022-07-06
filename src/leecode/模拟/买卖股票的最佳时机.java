package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/06/22:30
 * @Description:
 */
public class 买卖股票的最佳时机 {
    /**
     * 暴力解法，遍历所有的可能，找最大的差值！
     * O(T)=O(n^2)，两重for循环，时间复杂度太高，会超时！
     * O(S)=O(1)；
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]>prices[i]){
                    profit=Math.max(profit,prices[j]-prices[i]);
                }
            }
        }
        return profit;
    }
}
