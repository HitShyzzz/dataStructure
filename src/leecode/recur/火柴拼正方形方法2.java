package leecode.recur;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/01/21:35
 * @Description:
 */
public class 火柴拼正方形方法2 {
    public static void main(String[] args) {
        int[] matchsticks = {1,1,2,2,2};
        boolean makesquare = makesquare(matchsticks);
        System.out.println(makesquare);
    }

    /**
     * 状态压缩+动态规划
     *
     * @param matchsticks
     * @return
     */
    public static boolean makesquare(int[] matchsticks) {
        // 首先还是判断火柴数组的和是否是4的倍数
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int n = matchsticks.length;
        int len = sum / 4;
        // dp[s]记录正方形未放满边的长度，s表示第k个火柴取的状态，s=1表示选取第k个火柴；
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;// 未选取火柴，正方形未放满边的长度为0；
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                // 状态s未选取第k个火柴，则跳过，对应就是s的第k位为0；
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                // 如果去掉第k个火柴后的状态s1,满足dp[s1]>=0且dp[s1]+matchsticks[k]<=len,那么
                // dp[s]=(dp[s1]+matchsticks[k])%len;之所以要对len取模，是因为我们约定把上一条边填满之后，
                // 再来填充下一条边，此时未放满边的长度为0，因此要取余；【1 1 2 2 2 】
                // 去掉第k个火柴，即把状态s的第k为置为0；
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }
}
