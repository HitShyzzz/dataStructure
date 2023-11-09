package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/09/23:27
 * @Description:
 */
public class 交错字符串 {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean interleave = isInterleave(s1, s2, s3);
        System.out.println(interleave);
    }

    // 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    // 输出：true
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }
        // dp[i][j]表示s3的前i+j个字符串能否由s1[0,i]和s2[0,j]表示
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
