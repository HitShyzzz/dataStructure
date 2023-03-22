package leecode.数据结构;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/28/19:59
 * @Description:
 */
public class 第K个数 {
    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        Set<Long> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < k; i++) {
            long cur = pq.poll();
            ans = (int) cur;
            for (int factor : factors) {
                long next = cur * factor;
                if (set.add(next)) {
                    pq.offer(next);
                }
            }
        }
        return ans;
    }
}
