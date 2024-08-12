package leecode.动态规划;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 最小堆
 * @date: 2024-08-12 21:50
 */
public class 丑数II {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        // 最小堆
        PriorityQueue<Long> pq = new PriorityQueue<>();
        // 哈希表去重
        Set<Long> seen = new HashSet<>();
        pq.offer(1L);
        seen.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur = pq.poll();
            ugly = (int) cur;
            // 如果x是丑数，那么2x、3x、5x也都是丑数，
            for (int factor : factors) {
                long next = cur * factor;
                // 哈希表没记录存入的元素就入堆
                if (!seen.contains(next)) {
                    seen.add(next);
                    pq.offer(next);
                }
            }
        }
        return ugly;
    }
}
