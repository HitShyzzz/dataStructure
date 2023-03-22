package interview.TPLINK;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/19/16:19
 * @Description:
 */
public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    // [1, 2, 3, 2, 2, 2, 5, 4, 2]-----》2
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int candidate = nums[0];
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += (candidate == nums[i] ? 1 : -1);
        }
        return candidate;
    }
}
