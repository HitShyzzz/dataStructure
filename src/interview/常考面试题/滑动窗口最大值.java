package interview.常考面试题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/03/9:25
 * @Description:
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    // 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    // 输出: [3,3,5,5,6,7]
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // 大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        res[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            // 当堆顶元素落在了滑动窗口左边界的左侧，就可以永远的从滑动窗口中删除了
            while (!pq.isEmpty() && pq.peek()[1] <= i - k) {// 刚好在左侧也要移除
                pq.poll();
            }
            pq.offer(new int[]{nums[i], i});
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }
}
