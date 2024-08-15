package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-15 19:37
 */
public class 搜索旋转数组 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int search = search(nums, 0);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] <= nums[mid]) {// [l,mid]有序
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {// [mid+1,r]有序
                if (target >= nums[mid + 1] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
