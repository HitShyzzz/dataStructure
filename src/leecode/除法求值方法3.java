package leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/24/20:51
 * @Description:
 */
public class 除法求值方法3 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvar = 0;
        Map<String, Integer> map = new HashMap<>();
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(equations.get(i).get(0))) {
                map.put(equations.get(i).get(0), nvar++);
            }
            if (!map.containsKey(equations.get(i).get(1))) {
                map.put(equations.get(i).get(1), nvar++);
            }
        }
        int[] f = new int[nvar];// 记录每个点的父结点；
        double[] w = new double[nvar];// 记录每条边的权值
        Arrays.fill(w, 1.0);// 先把权值都默认设为1.0
        for (int i = 0; i < nvar; i++) {
            f[i] = i;// 先把每个节点的父节点设为自己。
        }
        for (int i = 0; i < n; i++) {
            int a = map.get(equations.get(i).get(0));
            int b = map.get(equations.get(i).get(1));
            merge(f, w, a, b, values[i]);
        }
        // 遍历问题集
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                int va = map.get(query.get(0));
                int vb = map.get(query.get(1));
                int fa = findf(f, w, va);
                int fb = findf(f, w, vb);
                if (fa == fb) {
                    result = w[va] / w[vb];
                }
            }
            res[i] = result;
        }
        return res;
    }

    // 找到x节点的父节点，并要更新新路径的权值
    public int findf(int[] f, double[] w, int x) {
        if (f[x] != x) {
            int father = findf(f, w, f[x]);
            w[x] = w[x] * w[f[x]];
            f[x] = father;
        }
        return f[x];
    }

    // 合并两个节点x和y,并更新权值
    public void merge(int[] f, double[] w, int x, int y, double val) {
        int fx = findf(f, w, x);
        int fy = findf(f, w, y);
        f[f[x]] = fy;
        w[fx] = w[y] / w[x] * val;
    }
}
