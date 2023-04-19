package leecode.dfs;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/18/11:27
 * @Description:
 */
public class 最长递增路径 {
    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int i = longestIncreasingPath(matrix);
        System.out.println(i);
    }

    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int longestIncreasingPath(int[][] matrix) {
        int[][] cache = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 对矩阵的每个结点进行深度优先搜索，那么最终的结果就是矩阵中每个点遍历后的最大值！
                ans = Math.max(ans, dfs(matrix, i, j, cache));
            }
        }
        return ans;
    }

    /**
     * 记忆化深度优先搜索
     *
     * @param matrix
     * @param i
     * @param j
     * @param cache  缓存矩阵，用来记录已经计算过的矩阵位置的最长递增路径长度
     * @return matrix[i][j]位置得到的最长递增路径长度
     */
    public static int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        // 遍历到当前结点，那么先把当前路径长度加1，表示选中了当前结点
        ++cache[i][j];
        for (int[] dir : dirs) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && matrix[newRow][newCol] > matrix[i][j]) {
                // cache[i][j]的值应该是上下左右四个方向深度优先搜索值加1的最大值，加1表示选择了对应方向的结点
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, newRow, newCol, cache) + 1);
            }
        }
        return cache[i][j];
    }
}
