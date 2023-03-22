package leecode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/20/9:43
 * @Description:
 */
public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        if (map.get(amount) != null) {
            return map.get(amount);
        }
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMin = coinChange(coins, amount - coins[i]);
            if (subMin == -1) {
                continue;
            }
            minCoins = Math.min(minCoins, subMin + 1);
            map.put(amount, minCoins);
        }
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
}
