package leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/08/10:47
 * @Description:
 */
public class 任务调度器 {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int leastTime = leastInterval(tasks, n);
        System.out.println(leastTime);
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;// 统计每个任务出现的次数
        }
        Arrays.sort(count);// 任务数组排序，保证需要执行次数最多的任务在数组末尾，即count[25]，可能会有并列；
        int j = 25;
        // 找出所有需要执行次数最多的任务，包括并列的；
        while (j >= 0 && count[j] == count[25]) {
            j--;
        }
        // 1.如果没有冷却时间，那么就返回tasks.length;
        // 2.否则的话就在所有需要执行次数最多的任务中间插空，最多的任务需要执行count[25]次，那么就有count[25]-1个空
        // 需要插，这些空间隔是n，再加上执行最多的任务本身就是n+1;最后末尾再加上需要执行最多次的任务25-j；
        return Math.max(tasks.length, (n + 1) * (count[25] - 1) + 25 - j);
    }
}
