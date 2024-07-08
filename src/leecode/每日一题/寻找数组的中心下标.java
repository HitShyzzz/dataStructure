package leecode.每日一题;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-08 20:18
 */
public class 寻找数组的中心下标 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += i > 0 ? nums[i - 1] : 0;
            if (nums[i] == sum - 2 * cur) {
                return i;
            }
        }
        return -1;
    }
}
