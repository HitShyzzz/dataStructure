package interview.中望软件.C;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/28/16:27
 * @Description:
 */
public class 最少跳跃次数 {
    public static void main(String[] args) {
        int[] jumps = {1, 2, 3};
        int jump = jump(jumps);
        System.out.println(jump);

    }

    /**
     * @param jumps
     * @return 到达最后一个位置的最少跳跃次数
     */
    public static int jump(int[] jumps) {
        if (jumps == null || jumps.length <= 1) {
            return 0;
        }
        int n = jumps.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (jumps[j] >= i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
