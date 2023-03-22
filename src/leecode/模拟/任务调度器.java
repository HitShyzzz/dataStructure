package leecode.模拟;

import java.util.Arrays;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/24/22:47
 * @Description:
 */
public class 任务调度器 {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int i = leastInterval(tasks, n);
        System.out.println(i);
    }

    /**
     * 最短时间，应该尽可能的在相同任务的冷却时间内，完成其他的任务，最后剩下的多余的相同任务，只能边冷却边完成了.
     * O(T)=O(tasks+Σ),Σ是任务数组的长度，首先需要tasks的时间去统计每个任务的次数，然后需要Σ的时间来找到并列
     * 最多任务次数的个数，
     * O(S)=O(Σ)，需要O(Σ)的空间来记录每个任务的次数！
     *
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval(char[] tasks, int n) {
        // 先统计每个任务的个数，同时找出需要完成次数最多的任务！
        int[] c = new int[26];
        int maxTasks = 0;
        for (char t : tasks) {
            c[t - 'A']++;
            if (c[t - 'A'] > maxTasks) {
                maxTasks = c[t - 'A'];
            }
        }
        // 统计并列完成次数最多任务的个数！
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == maxTasks) {
                count++;
            }
        }
        //["A","A","A","B","B","B", "C","C","C", "D", "D", "E"],n=2,此时最短时间应该是12；
        // 因为如果次数最多的任务个数count>n,那么这些次数最多的任务其实并不需要冷却啊，他们之间互相穿插完成就能用
        // 最短的时间完成所有的任务，此时完成任务的最短时间就是task.length;
        // if count>n,tasks.length>(maxTasks - 1) * (n + 1) + count,最短时间应该是tasks.length;
        // if count<=n,tasks.length<(maxTasks - 1) * (n + 1) + count,最短时间应该是(maxTasks - 1) * (n + 1) + count；
        // 因此最短时间就是二者的较大值！
        return Math.max(tasks.length, ((maxTasks - 1) * (n + 1) + count));
    }

}
