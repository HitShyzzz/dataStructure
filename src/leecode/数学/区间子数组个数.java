package leecode.数学;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/24/12:17
 * @Description:
 */
public class 区间子数组个数 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return CountSubarray(nums, right) - CountSubarray(nums, left - 1);
    }

    /**
     * @param nums
     * @param max
     * @return 数组nums小于等于max的子数组个数
     */
    public int CountSubarray(int[] nums, int max) {
        int count = 0;
        int subArray = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= max) {
                subArray++;
                count += subArray;
            } else {
                subArray = 0;
            }
        }
        return count;
    }
}
