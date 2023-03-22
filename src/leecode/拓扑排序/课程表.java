package leecode.拓扑排序;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/9:22
 * @Description:
 */
public class 课程表 {
    /**
     * 拓扑排序；用BFS实现；
     * 每次把入度为0的点加入队列，然后删除当前结点的所有出边，同时出边的入度-1。当入度-到0，就重新加入队列；
     * 如果已经遍历的点达到了n，说明所有的点都可以达到，否则就回存在环，有循环依赖，就不能到达所有的点；
     * O(T)=O(n+m),n是课程数，m是先修要求的课程数
     * O(S)=O(n+m),为了建立依赖关系，需要建立邻接表的形式，空间复杂度是O(n+m);
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();// 存放的是边
        int[] indeg = new int[numCourses];// 入度数组
        // 建图
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        // 添加依赖
        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }
        // BFS用的队列
        Queue<Integer> queue = new LinkedList<>();
        // 把入度为0的点加入队列
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;// 记录已经访问过的结点数目
        while (!queue.isEmpty()) {
            count++;
            int edge = queue.poll();
            // 对于edge的所有出边入度要减1，
            for (int v : edges.get(edge)) {
                indeg[v]--;
                // 入度为0，就加入队列
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return count == numCourses;
    }
}
