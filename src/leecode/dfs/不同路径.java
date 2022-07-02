package leecode.dfs;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/15:07
 * @Description:
 */
public class 不同路径 {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int paths = uniquePaths(m, n);
        System.out.println(paths);
    }

    private static int path = 0;
    /**
     * 直接暴力dfs的话会超时，因此我们需要记忆化递归搜索，把之前算出来的结果存储起来，减少重复计算的次数！
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        dfs(m, n, 0, 0, visited);
        return path;
    }

    public static void dfs(int m, int n, int i, int j, boolean[][] visited) {
        if (i == m || j == n) {
            return;
        }
        if (i == m - 1 && j == n - 1) {
            path++;
            //System.out.println();
            return;
        }
        // 向下走
        if (i + 1 < m && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            // System.out.print("向下--->");
            dfs(m, n, i + 1, j, visited);
            visited[i + 1][j] = false;
        }
        // 向右走
        if (j + 1 < n && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            //System.out.print("向右--->");
            dfs(m, n, i, j + 1, visited);
            visited[i][j + 1] = false;
        }
    }
}
