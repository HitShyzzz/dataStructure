package leecode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/10/22:30
 * @Description:
 */
public class 岛屿数量方法2 {
    /**
     * 也可以用BFS，核心思路都是一样的，如果当前点是1就把它加入队列，并把它改成0；
     * O(T)=O(mn);
     * O(S)=O(Math.min(m,n));最坏情况下全都是陆地，队列的空间复杂度可以到达Math.min(m,n);
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> neighbors = new LinkedList<>();
                    neighbors.add(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!neighbors.isEmpty()) {
                        int[] position = neighbors.poll();
                        int row = position[0];
                        int col = position[1];
                        if (row > 0 && grid[row - 1][col] == '1') {
                            neighbors.add(new int[]{row - 1, col});
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < m && grid[row + 1][col] == '1') {
                            neighbors.add(new int[]{row + 1, col});
                            grid[row + 1][col] = '0';
                        }
                        if (col > 0 && grid[row][col - 1] == '1') {
                            neighbors.add(new int[]{row, col - 1});
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < n && grid[row][col + 1] == '1') {
                            neighbors.add(new int[]{row, col + 1});
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}
