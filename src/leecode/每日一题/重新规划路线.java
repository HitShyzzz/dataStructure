package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-12-07 21:28
 */
public class 重新规划路线 {
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int i = minReorder(n, connections);
        System.out.println(i);
    }

    // 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
    // 输出：3
    // 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
    public static int minReorder(int n, int[][] connections) {
        // 先构图
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : connections) {
            // e[0]到e[1]的结点我们标记为1，这些都是需要反向的，我们最后只要累加边标记为1的数目即可！
            g[e[0]].add(new int[]{e[1], 1});
            g[e[1]].add(new int[]{e[0], 0});
        }

        return dfs(0, -1, g);
    }

    /**
     * @description:
     * @author: shy
     * @date: 2023/12/7 21:53
     * @param:
     * @param: cur
     * @param: fa
     * @param: g
     * @return: int 表示cur以fa为父结点，cur子结点需要反向的数目
     **/
    public static int dfs(int cur, int fa, List<int[]>[] g) {
        int res = 0;
        for (int[] edge : g[cur]) {
            if (edge[0] == fa) {
                continue;
            }
            res += edge[1] + dfs(edge[0], cur, g);
        }
        return res;
    }
}
