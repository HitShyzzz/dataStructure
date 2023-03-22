package leecode.排序;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/16/23:30
 * @Description:
 */
public class 前K个高频元素方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /**
     * 建立大根堆，堆中直接放的就是频率前K高的元素，直接取出来就行了
     * O(T)=O(nlogn);这里堆的大小是n,因此堆排序的时间复杂度还是O(nlogn);
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
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for (Integer key : map.keySet()) {
            pq.offer(key);
        }
        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
