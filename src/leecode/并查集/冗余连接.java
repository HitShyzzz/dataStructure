package leecode.并查集;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/05/10:27
 * @Description:
 */
public class 冗余连接 {
    /**
     * 并查集！
     *
     * @param edges
     * @return 多余的边使得剩下的图变成无向无环图
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] pre = new int[n + 1];
        // 初始化先把每个结点的父结点设为自己
        for (int i = 1; i <= n; i++) {
            pre[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            // 如果这两个结点代表元不同，表示它们原来不相通，
            if (find(pre, node1) != find(pre, node2)) {
                // 现在把它们连通
                union(pre, node1, node2);
            } else {// 如果这两个结点代表元相同，表示它们原来就是连通的，它们就是多余的边
                return edge;
            }
        }
        return new int[0];
    }

    // 查找x的代表元
    public int find(int[] pre, int x) {
        if (x == pre[x]) {// 递归出口
            return x;
        }
        // 一级一级享受查找，
        return pre[x] = find(pre, pre[x]);
    }

    // 合并两个结点
    public void union(int[] pre, int x, int y) {
        int prex = find(pre, x);// 得到x的代表元
        int prey = find(pre, y);// 得到y的代表元
        if (prex != prey) {// 代表元不相同，就进行合并
            pre[prex] = prey;
        }
    }
}
