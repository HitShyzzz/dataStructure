package leecode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/24/16:40
 * @Description:
 */
public class 除法求值 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvar = 0;// 记录equations中所有不重复点的数量
        Map<String, Integer> map = new HashMap<>();// 只是为了记录equations中所有不重复点的数量
        // 就是为了记录equations中所有不重复点的数量,同时给节点编号！
        for (int i = 0; i < equations.size(); i++) {
            if (!map.containsKey(equations.get(i).get(0))) {
                map.put(equations.get(i).get(0), nvar++);
            }
            if (!map.containsKey(equations.get(i).get(1))) {
                map.put(equations.get(i).get(1), nvar++);
            }
        }
        // 对于每个点，存储其直接相连的所有点的边的权值
        List<Pair>[] edges = new List[nvar];
        for (int i = 0; i < nvar; i++) {
            edges[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < equations.size(); i++) {
            int va = map.get(equations.get(i).get(0));
            int vb = map.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }
        double[] res = new double[queries.size()];// 存储结果集
        // 开始遍历问题集
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            double result = -1.0;// 存储每个问题结果的变量
            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                int a = map.get(query.get(0));
                int b = map.get(query.get(1));
                if (a == b) {
                    result = 1.0;
                } else {// 开始广度优先搜索
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(a);
                    double[] points = new double[nvar];// 点的数组
                    Arrays.fill(points, -1.0);// 填充-1.0是为了方便遍历的时候知道哪些点没有遍历
                    points[a] = 1.0;// 点a已经添加进队列，已经访问过了。
                    while (!queue.isEmpty() && points[b] < 0) {
                        int x = queue.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            if (points[y] < 0) {
                                points[y] = points[x] * val;
                                queue.offer(y);
                            }
                        }
                    }
                    result = points[b];
                }
            }
            res[i] = result;
        }
        return res;
    }

    class Pair {
        int index; // 点的编号
        double value; // 这个点直接连接到其他点的边的权值

        public Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
}
