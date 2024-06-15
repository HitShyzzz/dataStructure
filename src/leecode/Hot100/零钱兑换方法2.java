package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-15 9:41
 */
public class 零钱兑换方法2 {

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] == 100001 ? -1 : dp[amount];
    }
}
