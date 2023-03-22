package leecode;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/24/19:47
 * @Description:
 */
public class 除法求值方法2 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvar = 0;
        Map<String, Integer> map = new HashMap<>();
        int n = equations.size();
        // 统计equations中不同点的数量，并为每个点编号！
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(equations.get(i).get(0))) {
                map.put(equations.get(i).get(0), nvar++);
            }
            if (!map.containsKey(equations.get(i).get(1))) {
                map.put(equations.get(i).get(1), nvar++);
            }
        }
        // 构建图
        double[][] graph = new double[nvar][nvar];
        for (int i = 0; i < nvar; i++) {
            Arrays.fill(graph[i], -1.0);// 填充-1是为了包含有的点无法到达的情况
        }
        // 两个点可以直接相连的情况
        for (int i = 0; i < n; i++) {
            int va = map.get(equations.get(i).get(0));
            int vb = map.get(equations.get(i).get(1));
            graph[va][vb] = values[i];
            graph[vb][va] = 1.0 / values[i];
        }
        // 两个点间接相连的情况
        for (int k = 0; k < nvar; k++) {
            for (int i = 0; i < nvar; i++) {
                for (int j = 0; j < nvar; j++) {
                    if (graph[i][k] > 0 && graph[k][j] > 0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }
        // 遍历问题集合
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                int a = map.get(query.get(0));
                int b = map.get(query.get(1));
                if (graph[a][b] > 0) {
                    result = graph[a][b];
                }
            }
            res[i] = result;
        }
        return res;
    }
}
