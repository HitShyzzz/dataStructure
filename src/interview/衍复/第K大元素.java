package interview.衍复;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 堆排序，O(T)=O(NlogK)
 * @date: 2024-06-30 20:20
 */
public class 第K大元素 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }

    // 输入: [3,2,3,1,2,4,5,5,6], k = 4
    // 输出: 4
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) pq.offer(nums[i]);
        for (int i = k; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
            } else if (pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }

}
