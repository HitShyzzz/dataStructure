package leecode.并查集;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/11/11:04
 * @Description:
 */
public class 情侣牵手 {
    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3};
        int i = minSwapsCouples(row);
        System.out.println(i);
    }

    public static int minSwapsCouples(int[] row) {
        int N = row.length / 2;
        UnionFinder unionFinder = new UnionFinder(N);
        for (int i = 0; i < row.length; i += 2) {
            unionFinder.union(row[i] / 2, row[i + 1] / 2);
        }
        // 最少交换次数=情侣对数-并查集连通分量个数
        return N - unionFinder.getCnt();
    }
}

class UnionFinder {
    public int cnt;
    public int[] parent;

    public UnionFinder(int n) {
        this.cnt = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int getCnt() {
        return this.cnt;
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx == rooty) {
            return;
        }
        parent[rootx] = rooty;
        cnt--;
    }
}
