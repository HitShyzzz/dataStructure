package leecode.剑指offer突击版;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/20/8:53
 * @Description:
 */
public class 所有路径 {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();// 记录遍历途中遇到的结点

    // 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
    //输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        stack.offerLast(0);
        dfs(graph, 0, n - 1);
        return ans;
    }

    /**
     * 从cur顶点出发去找到达n的路径
     * 0-->4
     * 0-->3-->4
     * 0-->1-->3-->4
     * 0-->1-->2-->3-->4
     * 0-->1-->4
     * @param graph
     * @param cur
     * @param n
     */
    public void dfs(int[][] graph, int cur, int n) {
        if (cur == n) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int y : graph[cur]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }

}
