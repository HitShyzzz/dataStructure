package leecode.拓扑排序;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/17/11:08
 * @Description:
 */
public class 课程顺序 {
    // 输入: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
    // 输出: [0,1,2,3] or [0,2,1,3]
    // 解释:总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
    // 因此，一个正确的课程顺序是[0,1,2,3] 。另一个正确的排序是[0,2,1,3] 。

    /**
     * 拓扑排序
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] graph = new Set[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        int[] indegrees = new int[numCourses];
        for (int[] course : prerequisites) {
            int prev = course[1];
            int next = course[0];
            if (graph[prev].add(next)) {
                indegrees[next]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        // 把入度为0的结点加入队列
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int[] ans = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans[index++] = cur;
            for (Integer next : graph[cur]) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (index < numCourses) {
            return new int[]{};
        }
        return ans;
    }
}
