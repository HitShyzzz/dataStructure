package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/22/13:57
 * @Description:
 */
public class 比特位计数方法2 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int highBit = 0;
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            dp[i] = dp[i - highBit] + 1;
        }
        return dp;
    }
}
