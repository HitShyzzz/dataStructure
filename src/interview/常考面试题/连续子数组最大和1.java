package interview.常考面试题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/02/9:04
 * @Description:
 */
public class 连续子数组最大和1 {
    // -2 1 -3 4 -1 2 1 -5 4
    // 3 6
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] ints = maxSubArray(nums);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /**
     * @param nums
     * @return 连续最大子数组和的起始下标和终点下标
     */
    public static int[] maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int[] res = new int[2];
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                start = i;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
                res = new int[]{start, i};
            }
        }
        return res;
    }
}
