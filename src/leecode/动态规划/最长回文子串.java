package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/15/18:30
 * @Description:
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n; i++) {
                int j = l + i - 1;
                if (j >= n) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (l <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                System.out.print(dp[i][j] + " ");
                if (dp[i][j]) {
                    String temp = s.substring(i, j + 1);
                    if (temp.length() > ans.length()) {
                        ans = temp;
                    }
                }
            }
            System.out.println();
        }
        return ans;
    }
}
