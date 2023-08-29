package leecode.贪心;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/08/17/17:41
 * @Description:
 */
public class 加油站方法2 {
    public static void main(String[] args) {
        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    // 会超时！
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // cur[i]表示到达第i个站的油数量
        int[] cur = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            // 这样才能保证到达下一个出发点
            if (gas[i] >= cost[i]) {
                int curr = i;
                int nex;
                cur[curr] = gas[i];
                while (set.add(curr)) {
                    nex = (curr + 1) % n;
                    cur[nex] = cur[curr] - cost[curr] + gas[nex];
                    if (cur[nex] < cost[nex]) {
                        break;
                    }
                    curr = nex;
                }
                if (set.size() == n) {
                    return i;
                } else {
                    set.clear();
                    Arrays.fill(cur, 0);
                }
            }
        }
        return -1;
    }
}
