package leecode.动态规划;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/09/13:42
 * @Description:
 */
public class 最大加号标志方法2 {
    public static void main(String[] args) {
        int n = 5;
        int[][] mines = {{4, 2}};
        int i = orderOfLargestPlusSign(n, mines);
        System.out.println(i);
    }

    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] matrix = new int[n][n];
        // 把原来是0的位置填充成1，原来是1的数组初始化默认就是0；
        for (int i = 0; i < mines.length; i++) {
            matrix[mines[i][0]][mines[i][1]] = 1;
        }
        // dp[i][j][k]表示的在第k个方向上，以matrix[i][j]为起点连续1的最大个数，那么以
        // matrix[i][j]为起点的加号的最大层数就是所有dp[i][j][k]的最小值，其中k=0,1,2,3,分别表示上下左右四个方向
        // 在实际计算过程中我们只需要存储每个方向上连续1的最小数就行；
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, n);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            // 向上
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[j][i] == 1) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
            count = 0;
            // 向下
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == 1) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            // 向左
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            // 向右
            count = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
