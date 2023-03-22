package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/18/10:34
 * @Description:
 */
public class 最长递增子序列方法3 {
    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(dp[i] + " ");
//        }
        return ans;
    }
}
