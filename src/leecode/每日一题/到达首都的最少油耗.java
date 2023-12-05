package leecode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-12-05 22:41
 */
public class 到达首都的最少油耗 {
    long res = 0;

    // 输入：roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
    // 输出：7
    // 解释：
    //-代表 2 到达城市 3 ，消耗 1 升汽油。
    //-代表 2 和代表 3 一起到达城市 1 ，消耗 1 升汽油。
    //-代表 2 和代表 3 一起到达首都，消耗 1 升汽油。
    //-代表 1 直接到达首都，消耗 1 升汽油。
    //-代表 5 直接到达首都，消耗 1 升汽油。
    //-代表 6 到达城市 4 ，消耗 1 升汽油。
    //-代表 4 和代表 6 一起到达首都，消耗 1 升汽油。
    // 最少消耗 7 升汽油。
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        int[] arr = new int[n];
        List<Integer>[] g = new List[n + 1];
        // 建图
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            g[road[0]].add(road[1]);
            g[road[1]].add(road[0]);
        }
        dfs(0, -1, seats, g);
        return res;
    }

    /**
     * @description: 贪心的让当前结点x的子结点都到达结点x之后，再一起坐车出发，
     * 如果cur以fa为父结点，cur子树的大小是cnt，那么需要的车数就是cnt/seats向上取整，
     * 车的数量就是需要的汽油的数量！
     * @author: shy
     * @date: 2023/12/5 22:48
     * @param:
     * @param: cur
     * @param: fa
     * @param: seats
     * @param: g
     * @return: int 表示cur以fa为父结点，cur子树的大小
     **/
    public int dfs(int cur, int fa, int seats, List<Integer>[] g) {
        int peopleSum = 1;
        for (Integer son : g[cur]) {
            if (son != fa) {
                int cnt = dfs(son, cur, seats, g);
                // 累加cur所有孩子结点到cur的路径长度，也就是cur子树的大小
                peopleSum += cnt;
                // 累加所有的车数cnt/seats向上取整！
                res += (cnt % seats == 0 ? 0 : 1) + (cnt / seats);
            }
        }
        return peopleSum;
    }

}
