package leecode.Hot100;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-16 15:11
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    // 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    // 输出：[3,3,5,5,6,7]
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // 大根堆存放的是数组元素nums[i]和下标i，相同元素按下标从大到小排序
        //PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            // 如果堆顶元素下标在左窗口之外，就弹出堆
            while (pq.peek()[1] < i - k + 1) pq.poll();
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
