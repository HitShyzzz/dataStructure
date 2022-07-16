package leecode.排序;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/16/23:10
 * @Description:
 */
public class 前K个高频元素 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /**
     * 先用map去统计每个元素出现的次数，然后再返回出现次数最高的前k个就好！
     * O(T)=O(nlogn),对list进行排序时间复杂度会达到O(nlogn);
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
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
