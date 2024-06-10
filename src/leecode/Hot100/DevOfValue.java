package leecode.Hot100;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-10 14:42
 */
public class DevOfValue {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>() {{
            add(List.of("a", "b"));
            add(List.of("b", "c"));
        }};
        System.out.println(equations);
        double[] values = {2, 0, 3.0};
        List<List<String>> queries = new ArrayList<>() {{
            add(List.of("a", "c"));
            add(List.of("b", "a"));
            add(List.of("a", "e"));
            add(List.of("a", "a"));
            add(List.of("x", "x"));
        }};
        System.out.println(queries);
        DevOfValue devOfValue = new DevOfValue();
        double[] doubles = devOfValue.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(doubles));
    }

    // 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
    // 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        Map<String, Integer> map = new HashMap<>();
        Union union = new Union(2 * n);
        int id = 0;
        // 初始化图
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            String val1 = equation.get(0);
            String val2 = equation.get(1);
            if (!map.containsKey(val1)) {
                map.put(val1, id++);
            }
            if (!map.containsKey(val2)) {
                map.put(val2, id++);
            }
            union.union(map.get(val1), map.get(val2), values[i]);
        }
        // 查询图，思路就是找出两个节点的共同根节点（转换为同一个变量的倍数关系），权重相比
        int size = queries.size();
        double[] res = new double[size];
        for (int i = 0; i < size; i++) {
            String val1 = queries.get(i).get(0);
            String val2 = queries.get(i).get(1);
            if (!map.containsKey(val1) || !map.containsKey(val2)) res[i] = -1.0d;
            else res[i] = union.connected(map.get(val1), map.get(val2));
        }
        return res;
    }
}

class Union {

    private int[] parent;

    private double[] weight;

    public Union(int n) {
        this.parent = new int[n];
        this.weight = new double[n];
        for (int i = 0; i < n; i++) {
            // 初始化每个节点的父节点为自己
            parent[i] = i;
            // 当前节点指向父亲节点的初始权重为1
            weight[i] = 1.0d;
        }
    }

    public int find(int x) {

        if (x != parent[x]) {
            int origin = parent[x];
            parent[x] = find(origin);
            // 权重更新为x的权重乘以原来父节点权重
            weight[x] = weight[x] * weight[origin];
        }
        return parent[x];
    }

    public void union(int x, int y, double value) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootY == rootX) return;
        parent[rootX] = rootY;
        // weight[rootX]*weight[x]=weight[y]*value
        weight[rootX] = weight[y] * value / weight[x];
    }

    public double connected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return weight[x] / weight[y];
        } else {
            return -1.0d;
        }
    }
}