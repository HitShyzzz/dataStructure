package leecode.dfs;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/10/20:12
 * @Description:
 */
public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 核心思路就是对于每个点，如果是1，就把他改成0；不停的向上下左右四个方向遍历就好！
     * O(T)=O(mn);
     * O(T)=O(mn);最坏情况下每个点都是陆地，则空间复杂度达到O(mn);
     *
     * @param grid
     * @param i
     * @param j
     */
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return;
        }
        // 访问当前结点
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}
