package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-04 16:51
 */
public class 正则表达式匹配 {
    // 输入：s = "aa", p = "a*"
    // 输出：true
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (match(s, p, i, j - 1)) {// 看s[i]和p[j-1]能否匹配
                        // 如果*不再继续匹配，dp[i][j]=dp[i][j-2]
                        // 如果*继续匹配，dp[i][j]=dp[i-1][j]
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    // s[i]和p[j]能否正常匹配
    public boolean match(String s, String p, int i, int j) {
        if (i == 0)
            return false;
        if (p.charAt(j - 1) == '.')
            return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
