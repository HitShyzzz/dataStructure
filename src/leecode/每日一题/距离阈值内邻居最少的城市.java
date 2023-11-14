package leecode.每日一题;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/14/20:40
 * @Description:
 */
public class 距离阈值内邻居最少的城市 {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;
        int theCity = findTheCity(n, edges, distanceThreshold);
        System.out.println(theCity);
    }

    // n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Floyd算法求出每两个结点之间的最短路径，然后求出最短路径中在距离阈值内的结点数目
        int[] ans = {Integer.MAX_VALUE / 2, -1};// ans[0]表示最少邻居结点的数目，ans[1]表示结点编号
        int[][] map = new int[n][n];// 建立图的邻接矩阵
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE / 2);
        }
        for (int[] ed : edges) {
            int from = ed[0], to = ed[1], weight = ed[2];
            map[from][to] = map[to][from] = weight;
        }
        // Floyd算法求出每两个结点之间的最短路径
        for (int k = 0; k < n; k++) {
            map[k][k] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt <= ans[0]) {
                ans[0] = cnt;
                ans[1] = i;
            }
        }
        return ans[1];
    }
}
