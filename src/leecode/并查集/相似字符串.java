package leecode.并查集;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/05/11:45
 * @Description:
 */
public class 相似字符串 {
    /**
     * 并查集，返回连通分支个数就ok
     *
     * @param strs
     * @return 相似字符串能分成的组数
     */
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int[] pre = new int[n];
        // 先把每个结点的父节点设为自己
        for (int i = 0; i < n; i++) {
            pre[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // i和j的父节点相同，同一个连通分支，直接跳过！
                if (find(pre, i) == find(pre, j)) {
                    continue;
                }
                // 不同的连通分支，检查是否相似，如果相似，就要进行合并
                if (check(strs[i], strs[j])) {
                    union(pre, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 求出连通分支个数
            if (i == pre[i]) {
                res++;
            }
        }
        return res;
    }

    /**
     * @param s
     * @param t
     * @return s和t是否是相似字符串
     */
    public boolean check(String s, String t) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                cnt++;
                if (cnt > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param pre
     * @param x
     * @return x的代表元
     */
    public int find(int[] pre, int x) {
        if (pre[x] == x) {
            return x;
        }
        return pre[x] = find(pre, pre[x]);
    }

    /**
     * 合并结点x和y
     *
     * @param pre
     * @param x
     * @param y
     */
    public void union(int[] pre, int x, int y) {
        int prex = find(pre, x);
        int prey = find(pre, y);
        if (prex != prey) {
            pre[prex] = prey;
        }
    }
}
