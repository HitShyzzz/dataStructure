package interview.昆仑万维;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/05/19:23
 * @Description:
 */
public class Main3 {
    public int search(int[] nums, int target) {
        // write code here
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
