package leecode.Hot100;

import java.util.*;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-02 18:57
 */
public class 找出数组中消失的数字 {

    // O(S)=O(N)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().toList());
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
