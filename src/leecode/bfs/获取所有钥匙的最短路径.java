package leecode.bfs;

import leecode.模拟.下一个排列;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/10/10:03
 * @Description:
 */
public class 获取所有钥匙的最短路径 {

    public int shortestPathAllKeys(String[] grid) {
        // 代表上下左右四个方向
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length();
        // 起始坐标
        int startx = 0;
        int starty = 0;
        // 存储每种钥匙的编号
        Map<Character, Integer> map = new HashMap<>();
        // 先找到起始坐标和钥匙的数量
        // value是每种钥匙的编号，0，1，...,count-1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startx = i;
                    starty = j;
                } else if (Character.isLowerCase(c)) {
                    if (!map.containsKey(c)) {
                        int inx = map.size();
                        map.put(c, inx);
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        // (x,y,mask) (x,y)是当前坐标，mask是标志位，表示当前坐标获得钥匙的状态，获得了第i把钥匙才会把第i位置为1，
        // dist[x][y][mask]表示的是到达[x][y]走的步数；
        int[][][] dist = new int[m][n][1 << map.size()];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        dist[startx][starty][0] = 0;
        queue.offer(new int[]{startx, starty, 0});
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            int x = a[0];
            int y = a[1];
            int mask = a[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx].charAt(ny) != '#') {
                    if (grid[nx].charAt(ny) == '.' || grid[nx].charAt(ny) == '@') {
                        if (dist[nx][ny][mask] == -1) {
                            dist[nx][ny][mask] = dist[x][y][mask] + 1;
                            queue.offer(new int[]{nx, ny, mask});
                        }
                        // 小写字母代表钥匙
                    } else if (Character.isLowerCase(grid[nx].charAt(ny))) {
                        // 获取当前钥匙的编号
                        int inx = map.get(grid[nx].charAt(ny));
                        // (nx,ny)还没有走过
                        if (dist[nx][ny][mask | (1 << inx)] == -1) {
                            dist[nx][ny][mask | (1 << inx)] = dist[x][y][mask] + 1;
                            // mask的每个位都是1，那么就找到了所有钥匙的最短路径，就直接返回
                            if ((mask | (1 << inx)) == ((1 << map.size()) - 1)) {
                                return dist[nx][ny][mask | (1 << inx)];
                            }
                            queue.offer(new int[]{nx, ny, mask | (1 << inx)});
                        }
                    } else {// 大写字母，也就是锁
                        // 先获得对应钥匙的编号
                        int inx = map.get(Character.toLowerCase(grid[nx].charAt(ny)));
                        // 只有nx,ny位置有钥匙并且nx,ny位置没有走过，才能走的通
                        if ((mask & (1 << inx)) != 0 && dist[nx][ny][mask] == -1) {
                            dist[nx][ny][mask] = dist[x][y][mask] + 1;
                            queue.offer(new int[]{nx, ny, mask});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
