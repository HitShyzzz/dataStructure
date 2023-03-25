package leecode.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/16/20:49
 * @Description:
 */
public class 零钱兑换方法2 {
    // 记录兑换amount的钱需要的最少硬币数
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 100;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }

    /**
     * 记忆化搜索，递归的去找答案，同时用hashMap来记录之前已经计算过的答案，来优化时间复杂度！
     * 虽然已经优化了，但好像还是会超时！
     * O(T)=O(amount*n);
     * O(S)=O(amount);
     *
     * @param coins
     * @param amount
     * @return 兑换amount的钱需要的最少硬币数
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        Integer key = amount;
        if (map.get(key) != null) {
            return map.get(key);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMin = coinChange(coins, amount - coins[i]);
            // subMin==-1,那么coins[i]<amount,当前硬币是兑换不了amount的钱的，就直接把它跳过！
            if (subMin == -1) {
                continue;
            }
            ans = Math.min(ans, subMin + 1);
            map.put(key, ans);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
