package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/15/21:48
 * @Description:
 */
public class K个元素最大和 {
    public int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max * k + k * (k - 1) / 2;
    }
}
