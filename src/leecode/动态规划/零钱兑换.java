package leecode.动态规划;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/16/20:13
 * @Description:
 */
public class 零钱兑换 {
    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }

    /**
     * 动态规划，设dp[i]表示兑换i的钱需要的最少硬币数，我们需要返回dp[amount];
     * if coins[j]<=i,dp[i]=min(dp[i-coins[j])+1,
     * O(T)=O(n*amount);n是coins数组的长度，amount是钱的数目；
     * O(S)=O(amount);
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
