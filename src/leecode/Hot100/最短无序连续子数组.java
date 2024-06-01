package leecode.Hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-01 17:02
 */
public class 最短无序连续子数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int unsortedSubarray = findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int left = 0;
        int right = nums.length - 1;
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                flag = false;
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != copy[i]) {
                right = i;
                break;
            }
        }
        return flag ? 0 : right - left + 1;
    }
}
