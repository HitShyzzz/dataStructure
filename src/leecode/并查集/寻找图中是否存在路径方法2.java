package leecode.并查集;

import java.security.PublicKey;
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
public class 寻找图中是否存在路径方法2 {
    /**
     * 方法2：DFS
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
        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }

    // 这个函数表示的就是从source到destination是否存在着一条路径
    public boolean dfs(int source, int destination, List<Integer> adj[], boolean[] visited) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        for (int next : adj[source]) {
            if (!visited[next] && dfs(next, destination, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}
