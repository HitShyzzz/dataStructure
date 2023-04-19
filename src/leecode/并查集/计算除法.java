package leecode.并查集;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/19/9:41
 * @Description:
 */
public class 计算除法 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        Union union = new Union(2 * size);
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for (int i = 0; i < size; i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            if (!map.containsKey(x)) {
                map.put(x, id++);
            }
            int idx = map.get(x);
            if (!map.containsKey(y)) {
                map.put(y, id++);
            }
            int idy = map.get(y);
            union.union(idx, idy, values[i]);
        }
        int n = queries.size();
        double[] ans = new double[n];
        for (int i = 0; i < n; i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            Integer idx = map.get(x);
            Integer idy = map.get(y);
            if (idx == null || idy == null) {
                ans[i] = -1.0d;
            } else {
                ans[i] = union.isConnected(idx, idy);
            }
        }
        return ans;
    }
}

class Union {
    int[] parent;// 记录每个结点的父结点
    double[] weight;// 记录每个结点指向其父结点的权值

    public Union(int n) {
        this.parent = new int[n];
        this.weight = new double[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1.0d;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        int origin = parent[x];
        parent[x] = find(parent[x]);
        weight[x] = weight[x] * weight[origin];
        return parent[x];
    }

    /**
     * @param x
     * @param y
     * @param value x-->y的比值
     */
    public void union(int x, int y, double value) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            parent[rootx] = rooty;
            // w[f(x)]=v(f(x))/v(f(y))=(v(x)/w(x))/(v(y)/w(y))=v(x)/v(y)*w(y)/w(x)=value*w(y)/w(x).
            weight[rootx] = value * weight[y] / weight[x];
        }
    }

    public double isConnected(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx == rooty) {
            return weight[x] / weight[y];
        } else {
            return -1.0d;
        }
    }
}
