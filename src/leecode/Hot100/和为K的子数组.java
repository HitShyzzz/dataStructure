package leecode.Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-01 18:31
 */
public class 和为K的子数组 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int k = 2;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int cnt = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                cnt += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cnt;
    }
}
