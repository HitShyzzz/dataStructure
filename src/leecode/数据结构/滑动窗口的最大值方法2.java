package leecode.数据结构;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/12/8:32
 * @Description:
 */
public class 滑动窗口的最大值方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /**
     * 利用优先级队列可以把时间复杂度降低到O(nlogn);
     * 因为相邻窗口公用了k-1个元素，求每个元素的最大值时，我们直接利用优先级队列去求每个窗口最大值，但这个最大值可能
     * 不在窗口内，位于窗口边界的左侧，那么这个最大值随着窗口的右移将永远不可能是最大值了，就可以把它扔出去；
     * O(T)=O(nlogn);
     * O(S)=O(logn);忽略存储结果的额外空间！
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // 优先级队列里放的是num和他的下标，相同元素放的是它靠右边的下标，这是为了尽可能让最大值在窗口内出现
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]));
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            // 当堆顶元素的下标在窗口左侧时，就要把它扔出去，因为随着窗口右移，它永远不可能是最大值！
            while (pq.peek()[1] < i - k + 1) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
