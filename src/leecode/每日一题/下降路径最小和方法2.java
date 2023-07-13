package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/07/13/15:53
 * @Description:
 */
public class 下降路径最小和方法2 {
    private int minSum = Integer.MAX_VALUE;

    // dfs 会超时！
    public int minFallingPathSum(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            dfs(matrix, 0, j, 0);
        }
        return minSum;
    }

    public void dfs(int[][] matrix, int i, int j, int sum) {
        if (i == matrix.length) {
            minSum = Math.min(minSum, sum);
            return;
        }
        int[] dirs = {-1, 0, 1};
        for (int nex : dirs) {
            int nexI = i + 1;
            int nexJ = j + nex;
            if (nexJ < 0 || nexJ >= matrix[0].length) {
                continue;
            }
            dfs(matrix, nexI, nexJ, sum + matrix[i][j]);
        }
    }
}
