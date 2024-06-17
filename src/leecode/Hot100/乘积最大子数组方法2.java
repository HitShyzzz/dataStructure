package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-17 22:03
 */
public class 乘积最大子数组方法2 {
    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        int i = maxProduct(nums);
        System.out.println(i);
    }

    // 输入: nums = [-2,3,-4]
    // 输出: 24
    // 解释: 子数组 [2,3] 有最大乘积 6。
    // 滚动数组代替动态规划数组，O(S)=O(1)
    public static int maxProduct(int[] nums) {
        int ans = nums[0];
        int a = 1;
        int b = 1;
        for (int i = 0; i < nums.length; i++) {
            int prevA = a;
            int PrevB = b;
            a = Math.max(Math.max(prevA * nums[i], PrevB * nums[i]), nums[i]);
            b = Math.min(Math.min(prevA * nums[i], PrevB * nums[i]), nums[i]);
            ans = Math.max(ans, a);
        }
        return ans;
    }
}
