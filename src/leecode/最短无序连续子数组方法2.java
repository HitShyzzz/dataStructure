package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/06/12:46
 * @Description:
 */
public class 最短无序连续子数组方法2 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = -1;
        int right = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
            if (nums[n - 1 - i] > min) {
                left = n - 1 - i;
            } else {
                min = nums[n - 1 - i];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
