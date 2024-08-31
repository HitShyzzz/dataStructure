package leecode.top50;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 动态规划
 * @date: 2024-08-26 21:18
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        String s = longestPalindrome("babad");
        System.out.println(s);
    }

    // 输入：s = "babad"
    // 输出："bab"
    // 解释："aba" 同样是符合题意的答案。
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        String res = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i + 1 <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    if (j - i + 1 > ans) {
                        ans = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
