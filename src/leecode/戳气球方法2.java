package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/18/11:37
 * @Description:
 */
public class 戳气球方法2 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];// dp[i][j]表示在开区间dp[i][j]填充满气球所能获得的最大硬币数
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n + 2; j++) {
                for (int mid = i + 1; mid < j; mid++) {
                    int sum = val[i] * val[mid] * val[j] + dp[i][mid] + dp[mid][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n + 1];
    }
}
