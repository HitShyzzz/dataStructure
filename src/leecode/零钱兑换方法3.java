package leecode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/20/11:00
 * @Description:
 */
public class 零钱兑换方法3 {
    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 利用贪心算法的思路对dfs进行剪枝，但就是有一些用例比较极端，过不了。。。
     * @param coins coins数组
     * @param amount 需要凑的钱数
     * @param index  访问coins下标的数组
     * @param count 记录需要用的硬币数
     */
    public void dfs(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        if (index < 0) {
            return;
        }
        for (int k = amount / coins[index]; k >= 0 && k + count < ans; k--) {
            dfs(coins, amount - k * coins[index], index - 1, count + k);
        }
    }
}
