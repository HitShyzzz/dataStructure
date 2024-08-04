package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-04 17:24
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        String s = longestPalindrome("ac");
        System.out.println(s);
    }

    // 输入：s = "babad"
    // 输出："bab"
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        String res = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j - i + 1 < 3) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
