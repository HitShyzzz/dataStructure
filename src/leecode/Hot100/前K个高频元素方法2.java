package leecode.Hot100;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-10 19:17
 */
public class 前K个高频元素方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    // 输入: nums = [1,1,1,2,2,3], k = 2
    // 输出: [1,2]
    // 堆排序，O(T)=O(Nlogk)
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (Integer i : map.keySet()) {
            // 始终维护小根堆中的元素个数为k个
            if (pq.size() < k) {
                pq.offer(i);
            } else if (map.get(i) > map.get(pq.peek())) {// 当前元素出现频率与堆顶元素出现次数比较，如果堆顶元素出现次数
                // 更少，就出堆并将当前元素加入小根堆
                pq.poll();
                pq.offer(i);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = pq.poll();
        return res;
    }
}
