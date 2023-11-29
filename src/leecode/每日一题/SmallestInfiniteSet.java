package leecode.每日一题;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2023-11-29 19:07
 */
public class SmallestInfiniteSet {
    private PriorityQueue<Integer> pq;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            pq.offer(i);
        }
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            return pq.poll();
        }
        return -1;
    }

    public void addBack(int num) {
        if (!pq.contains(num)) {
            pq.offer(num);
        }
    }
}
