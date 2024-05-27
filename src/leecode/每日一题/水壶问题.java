package leecode.每日一题;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-01-28 16:04
 */
public class 水壶问题 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0});
        Set<Long> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            if (visited.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            visited.add(hash(stack.peek()));
            int[] cur = stack.pop();
            int x = cur[0];
            int y = cur[1];
            if (x == targetCapacity || y == targetCapacity || x + y == targetCapacity) {
                return true;
            }
            // 把x倒满
            stack.push(new int[]{jug1Capacity, y});
            // 把x放空
            stack.push(new int[]{0, y});
            // 把y倒满
            stack.push(new int[]{x, jug2Capacity});
            // 把y放空
            stack.push(new int[]{x, 0});
            // 把x倒入y
            stack.push(new int[]{x - Math.min(x, jug2Capacity - y), y + Math.min(x, jug2Capacity - y)});
            // 把y倒入x
            stack.push(new int[]{x + Math.min(y, jug1Capacity - x), y - Math.min(x, y - Math.min(y, jug1Capacity - x))});
        }
        return false;
    }

    public long hash(int[] cur) {
        return cur[0] * 1000000L + cur[1];
    }
}
