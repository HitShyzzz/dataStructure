package interview.常考面试题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/03/8:49
 * @Description:
 */
public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 0;
        int search = search(nums, target);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // [0,mid]部分有序
            if (nums[0] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] <= nums[n - 1]) { // [mid,n-1]有序
                    if (target <= nums[r] && target > nums[mid]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
