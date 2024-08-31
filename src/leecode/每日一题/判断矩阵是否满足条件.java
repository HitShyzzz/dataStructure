package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-29 19:50
 */
public class 判断矩阵是否满足条件 {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 2}, {1, 0, 2}};
        boolean b = satisfiesConditions(grid);
        System.out.println(b);
    }

    // 输入：grid = [[1,0,2],[1,0,2]]
    // 输出：true
    public static boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                if (j + 1 < n && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
