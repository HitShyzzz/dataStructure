package interview.meituan;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/25/22:49
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = in.nextInt();
        }
        for (int i : candies) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] dp = new int[n + 1];
        dp[1] = candies[0];
        dp[2] = Math.max(candies[0], candies[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + candies[i - 1]));
        }
        for (int i = 0; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println(dp[n]);
    }
}
