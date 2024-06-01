package leecode.Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-01 10:37
 */
public class 任务调度器方法2 {
    public static void main(String[] args) {
        // char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int i = leastInterval(tasks, 2);
        System.out.println(i);
    }

    // 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
    // 输出：16
    // 解释：一种可能的解决方案是：
    // A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
    public static int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        // 记录同一个任务出现的最多次数
        int maxTask = 0;
        for (char task : tasks) {
            cnt[task - 'A']++;
            if (cnt[task - 'A'] > maxTask) {
                maxTask = cnt[task - 'A'];
            }
        }
        // 记录出现次数==maxTask的次数
        int count = 0;
        for (int c : cnt) {
            if (c == maxTask) {
                count++;
            }
        }
        // if count>n,那么多个出现次数最多的元素之间可以互相穿插来保证冷却时间，此时最短时间就是tasks.length
        // if count<=n,此时最多元素出现maxTask次，需要插maxTask-1个空，每个元素都需要间隔n个时间再次出现，所以就是
        // (maxTask-1)*(n+1)，再加上剩余的元素count无需再插空，在冷却n时间内随便排列都能完成，所以总的时间就是(maxTask-1)*(n+1)+count
        return Math.max(tasks.length, (maxTask - 1) * (n + 1) + count);
    }
}
