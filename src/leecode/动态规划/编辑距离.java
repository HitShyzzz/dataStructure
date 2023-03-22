package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/17:55
 * @Description:
 */
public class 编辑距离 {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        int distance = minDistance(word1, word2);
        System.out.println(distance);
    }

    /**
     * 有点复杂的动态规划题目；首先我们知道每个字符进行3种操作，两个字符串就是6种，但本质上不同的操作只有3种：①对word1末尾
     * 添加一个字符，②对word2末尾添加一个字符，③把word1末尾的字符替换成word2末尾的字符；
     * 设dp[i][j]表示把word1的前i个字符变成word2的前j个字符的最小操作数，那么
     * if word1[i]==word2[j],dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]);
     * else dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
     * 对于边界：dp[i][0]=i;表示把word1前i个字符替换成空串，需要i次操作，同理dp[0][j]=j;
     * O(T)=O(mn);
     * O(S)=O(mn);
     *b
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化上边界
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        // 初始化左边界
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
