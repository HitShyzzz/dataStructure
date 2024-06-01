package leecode.Hot100;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-01 10:37
 */
public class 任务调度器 {
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
        // 先统计重复字符个数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 任务种类
        int m = map.size();
        // 记录每个任务下次开始的时间
        List<Integer> nextValid = new ArrayList<>();
        // 记录每个任务剩余执行次数
        List<Integer> rest = new ArrayList<>();
        // 初始化nextValid和rest
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }
        int time = 0;
        // 找出下一个最早开始时间
        for (int i = 0; i < tasks.length; i++) {
            time++;
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            // best设置为都在冷却时剩余执行次数最多的任务！
            int best = -1;
            for (int j = 0; j < m; j++) {
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
