package interview.昆仑万维;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/05/19:38
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        int[] arr = {4, 8, 12, 16};
        int i = max_wave_arr_len(arr);
        System.out.println(i);
    }

    public static int max_wave_arr_len(int[] arr) {
        // write code here
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            if ((arr[i] > arr[i - 1])) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (arr[i] < arr[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}
