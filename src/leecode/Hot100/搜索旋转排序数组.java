package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 用mid将数组一分为二，一定有一部分是有序的，在有序的部分进行二分查找即可
 * @date: 2024-07-27 13:06
 */
public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int target = 3;
        int search = search(nums, target);
        System.out.println(search);
    }

    // 输入：nums = [4,5,6,7,0,1,2], target = 0
    // 输出：4
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] <= nums[mid]) {// 【l,mid】有序
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {// [mid,r]有序
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
