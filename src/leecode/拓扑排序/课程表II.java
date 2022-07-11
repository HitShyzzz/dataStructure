package leecode.拓扑排序;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/9:51
 * @Description:
 */
public class 课程表II {

    /**
     * 思路跟课程表I的思路是一样的，处理一下结果的输出就行了;
     * O(T)=O(n+m);n是课程数，m是先修课程数；
     * O(S)=O(n+m);
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] indeg = new int[numCourses];
        // 建图
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        // 构建依赖关系
        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }
        // 入度为0的点加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        // List<Integer> list = new ArrayList<>();
        int[] ans = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int edge = queue.poll();
            //list.add(edge);
            ans[index++] = edge;
            for (int v : edges.get(edge)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (index < numCourses) {
            return new int[]{};
        }
        return ans;
        // list转数组的一种写法
        // return list.size() < numCourses ? new int[]{} : list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
