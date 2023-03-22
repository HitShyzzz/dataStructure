package leecode.并查集;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/20/15:57
 * @Description:
 */
public class 除法求值 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationSize);
        // 把并查集的结点和id对应起来
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for (int i = 0; i < equationSize; i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            if (!map.containsKey(x)) {
                map.put(x, id++);
            }
            if (!map.containsKey(y)) {
                map.put(y, id++);
            }
            unionFind.union(map.get(x), map.get(y), values[i]);
        }
        // 开始查询
        int querySize = queries.size();
        double[] ans = new double[querySize];
        for (int i = 0; i < querySize; i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            Integer idx = map.get(x);
            Integer idy = map.get(y);
            if (idx == null || idy == null) {
                ans[i] = -1.0d;
            } else {
                ans[i] = unionFind.isConnect(idx, idy);
            }
        }
        return ans;
    }

    private class UnionFind {
        private int[] parent;// 记录每个结点的父结点
        private double[] weight;// 记录指向父结点的权值

        // 初始化并查集
        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;// 先把每个结点的父结点设为自己
                weight[i] = 1.0d;// 初始权值设为1；
            }
        }

        // 合并x结点和y结点,x->y的权值==value；
        public void union(int x, int y, double value) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return;
            }
            parent[rootx] = rooty;
            weight[rootx] = value * weight[y] / weight[x];
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return x结点根节点的id
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] = weight[x] * weight[origin];
            }
            return parent[x];
        }

        public double isConnect(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {// 在同一个并查集中，就直接返回结果
                return weight[x] / weight[y];
            } else {// 否则就返回-1.0；
                return -1.0d;
            }
        }
    }
}


