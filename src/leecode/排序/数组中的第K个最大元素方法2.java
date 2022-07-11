package leecode.排序;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/11:35
 * @Description:
 */
public class 数组中的第K个最大元素方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    /**
     * 堆排序，直接利用优先级队列这一数据结构！
     * O(T)=O(nlogn);
     * O(S)=O(logn);主要来自递归空间栈的调用！
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();
    }
}
