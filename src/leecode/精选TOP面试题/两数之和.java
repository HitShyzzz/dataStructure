package leecode.精选TOP面试题;

import java.util.Arrays;


/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-03-04 20:47
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        int a = 0;
        int b = 0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (copy[l] + copy[r] == target) {
                a = copy[l];
                b = copy[r];
                break;
            } else if (copy[l] + copy[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        l = 0;
        r = n - 1;
        while (l < r) {
            if ((nums[l] == a && nums[r] == b) || (nums[r] == a && nums[l] == b)) {
                return new int[]{l, r};
            } else if (nums[l] == a || nums[l] == b) {
                r--;
            } else if (nums[r] == b || nums[r] == a) {
                l++;
            } else {
                l++;
                r--;
            }
        }
        return new int[]{-1, -1};
    }
}
