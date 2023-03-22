package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/18:04
 * @Description:
 */
public class 最大正方形 {
    public static void main(String[] args) {
        char[][] matrix = {{'0', '1'}, {'1', '0'}};
        int i = maximalSquare(matrix);
        System.out.println(i);
    }

    /**
     * 设dp[i][j]表示以matrix[i][j]为右下角元素的全是1的最大正方形的边长！
     * 则if matrix[i][j]==0,dp[i][j]=0;
     * if matrix[i][j]==1,dp[i][j]=min(dp[i][j-1],dp[i-1][]j-1],dp[i-1][j])+1;
     * 边界条件就是 if i==0||j==0,dp[i][j]=1;
     * 最后最大的正方形面积就是max dp[i][j]的平方！
     * O(T)=O(mn);
     * O(S)=O(mn);
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int edge = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                    edge = Math.max(edge, dp[i][j]);
                }
            }
        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return edge * edge;
    }
}
