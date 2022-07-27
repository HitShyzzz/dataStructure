package leecode.中心扩散法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/27/11:45
 * @Description:
 */
public class 回文子串方法2 {
    public static void main(String[] args) {
        String s = "aaa";
        int i = countSubstrings(s);
        System.out.println(i);
    }

    /**
     * 动态规划，设dp[i][j]表示子串s[i,j]是否为回文子串，那么
     * if s[i]!=s[j],dp[i][j]=false;
     * if s[i]=s[j],还要分：①j-i<3,dp[i][j]=true;②j-i>=3,dp[i][j]=dp[i+1][j-1];
     * 最后我们只要去统计所有为true的dp[i][j]的数目就行了!
     * O(T)=O(n^2);
     * O(S)=O(n^2);
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        // 这里要先让j到达最后，然后再让i去到达j，
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                // 这里我们其实只关心为true的dp,
                if (s.charAt(i) == s.charAt(j) && ((j - i) < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
