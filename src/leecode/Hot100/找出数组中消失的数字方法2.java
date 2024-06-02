package leecode.Hot100;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-02 18:57
 */
public class 找出数组中消失的数字方法2 {

    // O(S)=O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        // 每个元素本来的位置加n
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        for (int i = 0; i < n; i++) {
            // 如果≤n，就说明该位置元素缺失，没人给它加n
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
