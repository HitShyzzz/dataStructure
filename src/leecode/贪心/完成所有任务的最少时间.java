package leecode.贪心;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-15 22:04
 */
public class 完成所有任务的最少时间 {
    // 输入：tasks = [[2,3,1],[4,5,1],[1,5,2]]
    // 输出：2
    public int findMinimumTime(int[][] tasks) {
        int n = tasks.length;
        // 排序为了让后完成的任务能复用先完成的任务
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        // 统计[start[i],end[i]]区间内有哪些时间点运行了任务
        int[] run = new int[tasks[n - 1][1] + 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int start = tasks[i][0], end = tasks[i][1], duration = tasks[i][2];
            for (int j = start; j <= end; j++) {
                // 从左到右，复用区间[start,end]已经完成的任务
                duration -= run[j];
            }
            // 对于当前节点还要安排这么多的任务
            res += Math.max(duration, 0);
            // 对于区间[start,end]额外安排的任务，从右到左依次安排
            for (int j = end; j >= 0 && duration > 0; j--) {
                if (run[j] == 0) {
                    duration--;
                    run[j] = 1;
                }
            }
        }
        return res;
    }
}
