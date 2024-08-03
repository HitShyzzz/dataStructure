package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-02 9:45
 */
public class 直角三角形 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 1}, {1, 1}};
        long l = numberOfRightTriangles(grid);
        System.out.println(l);
    }

    // grid = [[1,0,1],[1,0,0],[1,0,0]]
    // 2
    public static long numberOfRightTriangles(int[][] grid) {
        // 计算每一行、每一列1的个数
        int m = grid.length;
        int n = grid[0].length;
        // rows[i]表示第i行1的个数
        int[] rows = new int[m];
        // cols[j]表示第j列1的个数
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        long cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && rows[i] > 1 && cols[j] > 1) {
                    // 其实是在拿rows[i]-1个1和cols[j]-1个1在排列组合
                    cnt += (long) (rows[i] - 1) * (cols[j] - 1);
                }
            }
        }
        return cnt;
    }
}
