package leecode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/08/13:41
 * @Description:
 */
public class 任务调度器方法2 {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int leastTime = leastInterval(tasks, n);
        System.out.println(leastTime);
    }

    public static int leastInterval(char[] tasks, int n) {

        // 用来统计各个任务需要执行的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        // 各类任务的总数
        int m = map.size();
        // 因为冷却限制，最早可以执行的时间
        List<Integer> nextValid = new ArrayList<>();
        // 剩余的执行次数
        List<Integer> rest = new ArrayList<>();
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for (Map.Entry<Character, Integer> entry : set) {
            int value = entry.getValue();
            // 每个任务默认的最早可执行时间都是1；
            nextValid.add(1);
            rest.add(value);
        }
        // 记录当前时间
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time++;
            // 所有nextValidi的最小值
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            // 只有当minNextValid才是有效的时间；
            time = Math.max(time, minNextValid);
            // 剩余需要执行次数最多的任务的编号
            int best = -1;
            for (int j = 0; j < m; j++) {
                // 我们需要找的是不在冷却中且剩余执行次数做多的任务为下次需要执行的任务
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                    if (best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }
        return time;
    }
}
