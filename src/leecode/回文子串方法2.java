package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/09/11:02
 * @Description:
 */
public class 回文子串方法2 {
    public static void main(String[] args) {
        String s = "aaa";
        int count = countSubstrings(s);
        System.out.println(count);
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        int ans = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 3) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
