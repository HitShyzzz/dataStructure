package leecode.dfs;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/21/9:49
 * @Description:
 */
public class 矩阵中的距离 {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int min;

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ints = updateMatrix(mat);
        for (int[] m : ints) {
            for (int i : m) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    min = Integer.MAX_VALUE;
                    int cnt = 0;
                    dfs(i, j, mat, cnt, visited);
                    res[i][j] = min;
                }
            }
        }
        return res;
    }

    // 返回从(x,y)位置出发找到0的最短距离
    public static void dfs(int x, int y, int[][] mat, int cnt, boolean[][] visited) {
        if (x < 0 || x == mat.length || y < 0 || y == mat[0].length || visited[x][y]) {
            return;
        }
        if (cnt > min) {
            return;
        }
        if (mat[x][y] == 0) {
            min = Math.min(min, cnt);
        }
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            dfs(nx, ny, mat, cnt + 1, visited);
        }
        visited[x][y] = false;
    }

}
