package leecode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-05-14 19:52
 */
public class 完成所有任务所需的最小轮数 {

    // tasks = [2,2,3,3,2,4,4,4,4,4]
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value == 1) {
                return -1;
            } else if (value <= 3) {
                cnt++;
            } else {
                cnt += (value % 3 == 0 ? 0 : 1) + value / 3;
            }
        }
        return cnt;
    }

}
