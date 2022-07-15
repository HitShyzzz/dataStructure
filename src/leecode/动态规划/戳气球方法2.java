package leecode.动态规划;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/15/23:55
 * @Description:
 */
public class 戳气球方法2 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        int i = maxCoins(nums);
        System.out.println(i);
    }


    /**
     * 动态规划，设dp[i][j]表示填充区间(i,j)能获得的最大硬币数！
     * 那么if i>=j-1,dp[i][j]=0;
     * if i<j-1,dp[i][j]=max(dp[i,mid]+dp[mid,j]+val[i]*val[mid]*val[j]),mid=i+1,...j-1;
     * 需要返回的是dp[0][n+1];
     * 这里要注意，因为我们要返回的是dp[0][n+1]，那么我们的i应该从n-1,...0,(i<j-1,j最大是n+1,i<n,i最大是n-1)
     * j=i+2(i<j-1,j>i+1,),...n+1.
     * 这样才符合动态规划的思想，
     * O(T)=O(n^3),
     * O(S)=O(n^2);
     *
     * @param nums
     * @return
     */
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        // 这样重新定义val数组只是为了方便处理边界条件
        int[] val = new int[n + 2];
        val[0] = 1;
        val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            // i<j-1,那么j>i+1,
            for (int j = i + 2; j < n + 2; j++) {
                for (int mid = i + 1; mid < j; mid++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][mid] + dp[mid][j] + val[i] * val[mid] * val[j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
