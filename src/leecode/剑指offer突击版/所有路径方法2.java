package leecode.剑指offer突击版;

import interview.常考面试题.ListNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/20/8:53
 * @Description:
 */
public class 所有路径方法2 {

    // 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
    //输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        queue.offer(list);
        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            int size = cur.size();
            for (int x : graph[cur.get(size - 1)]) {
                List<Integer> tmp = new ArrayList<>(cur);
                tmp.add(x);
                if (x == n - 1) {
                    ans.add(tmp);
                } else {
                    queue.offer(tmp);
                }
            }
        }
        return ans;
    }


}
