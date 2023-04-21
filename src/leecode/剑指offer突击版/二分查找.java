package leecode.剑指offer突击版;

public class 二分查找 {
    public static void main(String[] args) {
        int[] nums = {-2, 2, 3, 3, 90, 120};
        int target = 3;
        int ans = find(nums, target);
        System.out.println(ans);
    }

    public static int find(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
