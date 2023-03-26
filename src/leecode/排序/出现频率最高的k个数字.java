package leecode.排序;

import leecode.每日一题.特殊数组的特征值;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/26/22:14
 * @Description:
 */
public class 出现频率最高的k个数字 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 2, 2, 3, 5, 3, 6, 4, 1};
        int k = 3;
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
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (pq.contains(nums[i])) {
                continue;
            }
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int j = 0; j < k; j++) {
            ans[j] = pq.poll();
        }
        return ans;
    }
}
