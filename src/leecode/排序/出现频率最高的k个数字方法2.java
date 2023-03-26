package leecode.排序;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/22:14
 * @Description:
 */
public class 出现频率最高的k个数字方法2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3, 2};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            int[] cur = new int[]{num, cnt};
            if (pq.size() == k) {
                // 当前元素出现的次数比堆顶元素次数多，
                if (cnt > pq.peek()[1]) {
                    pq.poll();
                    pq.offer(cur);
                }
            }else{
                pq.offer(cur);
            }
        }
        for (int j = 0; j < k; j++) {
            ans[j] = pq.poll()[0];
        }
        return ans;
    }
}
