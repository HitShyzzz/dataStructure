package leecode.排序;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/21:25
 * @Description:
 */
public class KthLargest1 {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest1(int k, int[] nums) {
        this.k = k;
        // 这里优先级队列的默认排序规则是从队头到队尾递增，也就是队尾到队头递减！
        pq = new PriorityQueue<>();
        for (int num : nums) {
            // 注意这里调用的是下面写的add方法，pq里面始终放的只有最大的k个元素，那么队头就是第k大的元素！
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
