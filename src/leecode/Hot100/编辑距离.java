package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-08 20:36
 */
public class 编辑距离 {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        int i = minDistance(word1, word2);
        System.out.println(i);
    }

    // 输入：word1 = "horse", word2 = "ros"
    // 输出：3
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]表示的是word1[0,i]子串替换成word2[0,j]子串的最少操作次数
        int[][] dp = new int[m + 1][n + 1];
        // 初始化边界条件
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {// word1[i]!=word2[j]时，dp[i][j]应该是与其相邻的三者的最小值+1，不管是替换、删除、增加一个字符的操作都在这三者之内
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
