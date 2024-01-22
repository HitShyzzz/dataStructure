package leecode.每日一题;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-12-08 19:34
 */
public class 出租车的最大盈利 {
    public static void main(String[] args) {
        int n = 20;
        int[][] rides = {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}};
    }

    // 输入：n = 20, rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]
    // 输出：20
    // 解释：我们可以接以下乘客的订单：
    //- 将乘客 1 从地点 3 送往地点 10 ，获得 10 - 3 + 2 = 9 元。
    //- 将乘客 2 从地点 10 送往地点 12 ，获得 12 - 10 + 3 = 5 元。
    //- 将乘客 5 从地点 13 送往地点 18 ，获得 18 - 13 + 1 = 6 元。
    // 我们总共获得 9 + 5 + 6 = 20 元
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        int m = rides.length;
        long[] dp = new long[m + 1];
        for (int i = 0; i < m; i++) {
            int j = binarySearch(rides, i, rides[i][0]);
            dp[i + 1] = Math.max(dp[i], dp[j] + rides[i][1] - rides[i][0] + rides[i][2]);
        }
        return dp[m];
    }

    public int binarySearch(int[][] rides, int high, int target) {
        int low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (rides[mid][1] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
