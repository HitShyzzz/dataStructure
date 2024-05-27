package leecode.精选TOP面试题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-03-07 22:08
 */
public class 正则表达式匹配 {
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
                    if (match(s, p, i, j - 1)) {
                        // 此时，如果*不再匹配，dp[i][j]=dp[i][j-2];
                        // 如果*继续匹配，dp[i][j]=dp[i-1][j];（可以把b*看成一个整体）
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    /**
     * @description: s[i]和p[j]能否匹配
     * @author: shy
     * @date: 2024/3/7 22:08
     * @param:
     * @param: s
     * @param: p
     * @param: i
     * @param: j
     * @return: boolean
     **/
    public boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
