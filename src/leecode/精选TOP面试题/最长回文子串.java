package leecode.精选TOP面试题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-03-08 20:23
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "cbbdddddddbbc";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    // 输入：s = "babad"
    // 输出："bab"
    // 解释："aba" 同样是符合题意的答案。
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int begin = 0;
        // 枚举子串长度L！
        for (int L = 1; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                int j = L + i - 1;
                if (j >= n) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (L < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    if (L > maxLen) {
                        maxLen = L;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
