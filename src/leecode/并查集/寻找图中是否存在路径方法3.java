package leecode.并查集;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/12/19/11:16
 * @Description:
 */
public class 寻找图中是否存在路径方法3 {
    /**
     * 方法3：并查集
     *
     * @param n           顶点个数
     * @param edges       边数组
     * @param source      起始顶点
     * @param destination 目标顶点
     * @return 否则存在起始顶点source到目标顶点destination的路径
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        UnionFind find = new UnionFind(n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            find.union(x, y);
        }
        return find.connect(source, destination);
    }
}

class UnionFind {
    private int[] parent;// 记录每个节点的父节点
    private int[] rank;// 记录每个节点的秩，也就是集合的大小

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // 查找某个节点的父节点
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        // 在查找x的父节点时把中间的节点的父节点就行了更新，实现了状态压缩，提高了查找效率！
        return parent[x] = find(parent[x]);
    }

    // 把节点x和y进行合并
    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx == rooty) {
            return;
        }
        // 把秩小的集合挂到秩大的集合上去
        if (rank[rootx] > rank[rooty]) {
            parent[rooty] = rootx;
            rank[rootx] += rank[rooty];
        } else {
            parent[rootx] = rooty;
            rank[rooty] += rank[rootx];
        }
    }

    // 判断x和y是否连通
    public boolean connect(int x, int y) {
        return find(x) == find(y);
    }
}
