package leecode.并查集;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/12/19/11:16
 * @Description:
 */
public class 寻找图中是否存在路径 {
    /**
     * 方法1：BFS
     *
     * @param n           顶点个数
     * @param edges       边数组
     * @param source      起始顶点
     * @param destination 目标顶点
     * @return 否则存在起始顶点source到目标顶点destination的路径
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer> adj[] = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // 对于每个顶点构建邻接点
        for (int edge[] : edges) {
            int x = edge[0];
            int y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        boolean[] visited = new boolean[n];
        visited[source] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == destination) {
                break;
            }
            for (int next : adj[cur]) {
                // 如果没访问过就去访问
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return visited[destination];
    }
}
