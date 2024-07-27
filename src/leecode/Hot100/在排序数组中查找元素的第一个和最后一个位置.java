package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-27 12:47
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                int r_max = mid;
                while (r_max < nums.length && nums[r_max] == target) {
                    r_max++;
                }
                int l_min = mid;
                while (l_min >= 0 && nums[l_min] == target) {
                    l_min--;
                }
                return new int[]{l_min + 1, r_max - 1};
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
