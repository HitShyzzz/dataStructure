package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/20/19:47
 * @Description:
 */
public class 最大子数组和 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    // 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    // 输出：6
    // 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
}
