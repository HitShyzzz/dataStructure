package interview.衍复;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-19 16:25
 */
public class Main {
    // [1,2,3,4,6] start_time
    // [3,5,10,6,9] end_time
    // [20,20,100,70,60] profit
    // 150 output
    public static void main(String[] args) {
        int[] start = {1, 2, 3, 4, 6};
        int[] end = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};
        int i = get(start, end, profit);
        System.out.println(i);
    }

    public static int get(int[] start, int[] end, int[] profit) {
        int n = start.length;
        int[][] times = new int[n][3];
        for (int i = 0; i < n; i++) {
            times[i][0] = start[i];
            times[i][1] = end[i];
            times[i][2] = profit[i];
        }
        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);
        int[] dp = new int[n];
        dp[0] = profit[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int start_time = times[i][0];
            dp[i] = times[i][2];
            for (int j = 0; j < i; j++) {
                if (times[j][1] <= start_time) {
                    dp[i] = Math.max(dp[j] + times[i][2], dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }
}
