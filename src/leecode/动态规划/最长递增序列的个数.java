package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/18/10:48
 * @Description:
 */
public class 最长递增序列的个数 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        int numberOfLIS = findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];// 表示以nums[i]结尾的的最长递增序列的长度
        int[] cnt = new int[n];// 表示以nums[i]结尾的最长递增序列的个数
        int maxLen = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i];
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}
