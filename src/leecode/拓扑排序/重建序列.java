package leecode.拓扑排序;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/17/10:31
 * @Description:
 */
public class 重建序列 {
    // 输入：nums = [1,2,3], sequences = [[1,2],[1,3],[2,3]]
    //输出：true
    //解释：最短可能的超序列为[1,2,3]。
    //序列 [1,2] 是它的一个子序列：[1,2,3]。
    //序列 [1,3] 是它的一个子序列：[1,2,3]。
    //序列 [2,3] 是它的一个子序列：[1,2,3]。
    //因为 nums 是唯一最短的超序列，所以返回true。

    /**
     * 拓扑排序，每次都把入度为0的结点加入到队列中，然后再把当前结点取出，对应的出度结点出度减去1，如果新的结点入读为0，就把
     * 对应的结点加入到队列
     *
     * @param nums
     * @param sequences
     * @return
     */
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            // 存储每个结点的邻接结点
            graph[i] = new HashSet<>();
        }
        // 计算每个结点的入度
        int[] indegrees = new int[n + 1];
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int prev = sequence[i - 1];// 前一个结点
                int next = sequence[i];// 下一个结点
                if (graph[prev].add(next)) {
                    indegrees[next]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            // 把入度为0的结点加入到队列中
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            // 队列中元素个数可以表示下一个超序列可选的元素个数，超过1，那么超序列下一个可选元素就大于1，返回false。
            if (queue.size() > 1) {
                return false;
            }
            int point = queue.poll();
            for (Integer next : graph[point]) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}
