package leecode.Hot100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-17 20:09
 */
public class 课程表 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        boolean b = canFinish(numCourses, prerequisites);
        System.out.println(b);
    }

    // 输入：numCourses = 2, prerequisites = [[1,0]]
    // 输出：true
    // 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
    // 拓扑排序
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1、构图
        List<List<Integer>> edges = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            edges.get(y).add(x);
            indegrees[x]++;
        }
        // 2、入度为0的节点入队列
        Deque<Integer> q = new LinkedList<>();
        int visited = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) q.offer(i);
        }
        // 3、遍历队列，对每个入度为0的节点依次移除它的相邻节点
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited++;
            List<Integer> edge = edges.get(cur);
            for (int e : edge) {
                indegrees[e]--;
                if (indegrees[e] == 0) q.offer(e);
            }
        }
        return visited == numCourses;
    }
}
