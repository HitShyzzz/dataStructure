package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/16/19:53
 * @Description:
 */
public class 正则表达式匹配 {
    public static void main(String[] args) {
        String s = "ab";
        String p = ".*";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j]表示p[0,j)能否匹配s[0,i),是开区间
        boolean[][] dp = new boolean[m + 1][n + 1];
        // i==0,j==0表示s和p都是空串则能匹配成功！
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];

    }

    // 判断s[i-1]和p[j-1]是否匹配
    public static boolean match(String s, String p, int i, int j) {
        if (i == 0 && j > 0) {// s是空串，但p不是空串，则无法匹配
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
