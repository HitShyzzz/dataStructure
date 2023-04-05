package leecode.并查集;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/05/12:05
 * @Description:
 */
public class 省份数量 {
    /**
     * 并查集，求出连通分支个数即可
     *
     * @param isConnected
     * @return 矩阵图中省份的数量
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] pre = new int[n];
        // 先把每个结点的父节点设为自己
        for (int i = 0; i < n; i++) {
            pre[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < n; j++) {
                // 如果结点i,j是连通的，就要进行合并
                if (isConnected[i][j] == 1) {
                    union(pre, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 计算连通分支个数
            if (pre[i] == i) {
                res++;
            }
        }
        return res;
    }

    /**
     * @param pre
     * @param x
     * @return x的代表元
     */
    public int find(int[] pre, int x) {
        if (x == pre[x]) {
            return x;
        }
        return pre[x] = find(pre, pre[x]);
    }

    /**
     * 把结点x,y进行合并
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
