package interview.京东;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/01/20:16
 * @Description:
 */
public class Main21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int i = MinOperation(s);
        System.out.println(i);
    }

    public static int MinOperation(String s) {
        int n = s.length();
        // dp[i][0]表示把s[0,i]以r结尾的好串的最少操作次数
        // dp[i][1]表示把s[0,i]以e结尾的好串的最少操作次数
        // dp[i][2]表示把s[0,i]以d结尾的好串的最少操作次数
        // 我们要找的是min(dp[n-1][0],dp[n-1][1],dp[n-1][2])
        int[][] dp = new int[n][3];
        if (s.charAt(0) == 'r') {
            dp[0][1] = 1;
            dp[0][2] = 1;
        } else if (s.charAt(0) == 'e') {
            dp[0][0] = 1;
            dp[0][2] = 1;
        } else {
            dp[0][0] = 1;
            dp[0][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]);
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
                    dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                } else {
                    dp[i][0] = (i >= 2 ? Math.min(dp[i - 2][1], dp[i - 2][2]) : 0) + 1;
                    dp[i][1] = (i >= 2 ? Math.min(dp[i - 2][0], dp[i - 2][2]) : 0) + 1;
                    dp[i][2] = (i >= 2 ? Math.min(dp[i - 2][0], dp[i - 2][1]) : 0) + 1;
                }
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
