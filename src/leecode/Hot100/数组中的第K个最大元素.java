package leecode.Hot100;

import java.util.PriorityQueue;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-16 18:56
 */
public class 数组中的第K个最大元素 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }

    // 输入: [3,2,1,5,6,4], k = 2
    // 输出: 5
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
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
