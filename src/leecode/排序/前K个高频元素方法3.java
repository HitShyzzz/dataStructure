package leecode.排序;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/16/23:50
 * @Description:
 */
public class 前K个高频元素方法3 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /**
     * 建立小根堆，堆中放的是元素以及他们出现的次数；
     * 如果堆中元素小于k个，就把当前元素加入到堆中，如果堆中元素==k,那么需要比较，如果
     * 堆顶元素的个数大于当前元素的个数，那么至少有k个元素出现的次数比当前元素出现的次数还要多，因此要舍弃当前元素；
     * 否则的话就把堆顶元素扔出去，把当前元素加入堆！
     * <p>
     * O(T)=O(nlogk);这里堆的大小最多是k,因此堆排序的时间复杂度还是O(nlogk);
     * O(S)=O(n);
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 第1个元素表示num,第2个元素表示num出现的次数
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> o1[1] - o2[1]);
        for (Integer num : map.keySet()) {
            int count = map.get(num);
            if (pq.size() == k) {
                if (pq.peek()[1] < count) {
                    pq.poll();
                    pq.offer(new int[]{num, count});
                }
            } else {
                pq.offer(new int[]{num, count});
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
