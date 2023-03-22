package leecode.并查集;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/20/16:34
 * @Description:
 */
public class 除法求值方法2 {
    /**
     * 常规思路，如果x->y->z,那么weight[x->z]=weight[x->y]*weight[y->z];
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationSize = equations.size();
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        // 建立结点和id的对应关系
        for (int i = 0; i < equationSize; i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            if (!map.containsKey(x)) {
                map.put(x, id++);
            }
            if (!map.containsKey(y)) {
                map.put(y, id++);
            }
        }
        double[][] grid = new double[id][id];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], -1.0);// 填充-1.0是为了包含有的无法到达的点
        }
        for (int i = 0; i < equationSize; i++) {
            // 两个点直接相连的情况
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            Integer idx = map.get(x);
            Integer idy = map.get(y);
            grid[idx][idy] = values[i];
            grid[idy][idx] = 1.0 / values[i];
        }
        // 两个点间接相连的情况
        for (int k = 0; k < id; k++) {
            for (int i = 0; i < id; i++) {
                for (int j = 0; j < id; j++) {
                    if (grid[i][k] > 0 && grid[k][j] > 0) {
                        grid[i][j] = grid[i][k] * grid[k][j];
                    }
                }
            }
        }
        // 开始查询
        int querySize = queries.size();
        double[] ans = new double[querySize];
        for (int i = 0; i < querySize; i++) {
            double res = -1.0;
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (map.get(x) != null && map.get(y) != null) {
                if (grid[map.get(x)][map.get(y)] > 0) {
                    res = grid[map.get(x)][map.get(y)];
                }
            }
            ans[i] = res;
        }
        return ans;
    }
}
