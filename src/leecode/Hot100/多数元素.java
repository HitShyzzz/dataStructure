package leecode.Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-17 20:46
 */
public class 多数元素 {
    // 输入：nums = [2,2,1,1,1,2,2]
    // 输出：2
    // O(S)=O(N)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) return num;
        }
        return -1;
    }
}
