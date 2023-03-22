package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/01/9:10
 * @Description:
 */
public class 矩阵中的局部最大值 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int[][] matrix = new int[3][3];
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int s = j - 1; s <= j + 1; s++) {
                        matrix[k - (i - 1)][s - (j - 1)] = grid[k][s];
                    }
                }
                ans[i - 1][j - 1] = largestNum(matrix);
            }
        }
        return ans;
    }

    // 找出3*3矩阵的最大值
    public int largestNum(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }
}
