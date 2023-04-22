package leecode.并查集;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/22/9:27
 * @Description:
 */
public class 二分图 {
    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        boolean bipartite = isBipartite(graph);
        System.out.println(bipartite);
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] edge = graph[i];
            for (int adj : edge) {
                // 如果某一个邻接点和当前结点已经在同一个集合了，就不是二分图，因为二分图要求同一个集合内的所有
                // 点都不能互相连通
                if (isConnected(parent, i, adj)) {
//                    System.out.println(i);
//                    System.out.println(adj+"**");
                    return false;
                }
                // 合并当前顶点的所有邻接点
                union(parent, edge[0], adj);
            }
        }
//        for (int i:parent){
//            System.out.print(i+" ");
//        }
        return true;
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }

    public static void union(int[] parent, int x, int y) {
        int rootx = find(parent, x);
        int rooty = find(parent, y);
        if (rootx != rooty) {
            parent[rootx] = rooty;
        }
    }

    public static boolean isConnected(int[] parent, int x, int y) {
        return find(parent, x) == find(parent, y);
    }
}
