package leecode.dfs;

import java.security.PublicKey;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/22/10:15
 * @Description:
 */
public class 二分图 {
    public static final int UNCOLORED = 0;
    public static final int RED = 1;
    public static final int GREEN = 2;
    public int[] color;
    public boolean valid;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; i++) {
            // 给每一个没有着色的结点进行涂色
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    /**
     * @param node  当前结点
     * @param c     当前颜色
     * @param graph 图矩阵
     */
    public void dfs(int node, int c, int[][] graph) {
        // 先给当前结点着色
        color[node] = c;
        // 当前结点邻接点要图的颜色
        int cNex = (c == RED ? GREEN : RED);
        for (int nei : graph[node]) {
            // 邻接点没着色，那就继续着色
            if (color[nei] == UNCOLORED) {
                dfs(nei, cNex, graph);
                if (!valid) {
                    return;
                }
            } else if (color[nei] == c) {// 如果已经着色，但是与我们想图的颜色矛盾了（不同，也就是color[nei]==c）
                valid = false;
                return;
            }
        }
    }
}
