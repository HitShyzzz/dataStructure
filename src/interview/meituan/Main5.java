package interview.meituan;

import solution.泛型.Pair;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/20:51
 * @Description:
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = in.nextInt();
        }
        // dp[i][j]表示第i天使用了j次特权能吃到的最多的糖果
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], (i >= 2 ? dp[i - 2][0] : 0) + candies[i - 1]);
            System.out.print(dp[i][0] + " ");
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + candies[i - 1], dp[i - 1][j]);
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[n][k]);
    }
}
