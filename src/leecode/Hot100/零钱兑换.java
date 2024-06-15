package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-15 9:41
 */
public class 零钱兑换 {

    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // 会超时！
    public void dfs(int[] coins, int amount, int cnt) {
        if (amount < 0) return;
        if (amount == 0) {
            ans = Math.min(ans, cnt);
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            dfs(coins, amount - coins[i], cnt + 1);
        }
    }
}
