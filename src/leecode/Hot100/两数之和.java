package leecode.Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-04 19:10
 */
public class 两数之和 {
    // 输入：nums = [2,7,11,15], target = 9
    // 输出：[0,1]
    // 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
