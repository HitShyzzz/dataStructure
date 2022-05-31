package leecode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/06/11:41
 * @Description:
 */
public class 最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int pre = 0;
        int back = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                pre = i;
                break;
            }
        }
        for (int j = nums.length; j >= 0; j--) {
            if (nums[j] != copy[j]) {
                back = j;
                break;
            }
        }
        return (pre == 0 && back == 0) ? 0 : back - pre + 1;
    }
}
