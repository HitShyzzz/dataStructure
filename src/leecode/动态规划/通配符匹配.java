package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/07/10:34
 * @Description:
 */
public class 通配符匹配 {
    public static void main(String[] args) {
        String s = "cb";
        String p = "?a";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j]表示s[0,i]能否匹配[0,j].
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;// 两个都是空串是可以匹配的!
        // dp[0][j]只有p的前j个字符都是*，才能匹配，因为只有*才能匹配空串
        // dp[i][0]==false.
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        // p[j]='*'时，分两种情况，1，不用这个*，也就是*匹配空串，那么dp[i][j]=dp[i][j-1];
                        // 2,用这个*，那么dp[i][j]=dp[i-1][j];
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
