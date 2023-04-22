package leecode.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/22/10:29
 * @Description:
 */
public class 二分图 {
    public static final int UNCOLORED = 0;
    public static final int RED = 1;
    public static final int GREEN = 2;

    // 广度优先搜索实现二分图的判断
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n; i++) {
            // 当前结点未染色，就丢进队列进行染色
            if (color[i] == UNCOLORED) {
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                color[i] = RED;// 先默认染红色
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    // node的邻接点要染的颜色
                    int cnex = (color[node] == RED ? GREEN : RED);
                    for (int nei : graph[node]) {
                        // nei没染色就丢进队列去染色
                        if (color[nei] == UNCOLORED) {
                            queue.offer(nei);
                            color[nei] = cnex;
                        } else if (color[nei] == color[node]) {// nei要染的颜色与node颜色相同，也就是矛盾了，此时就说明它不是二分图
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
