package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-16 15:41
 */
public class 除自身以外数组的乘积方法2 {
    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] ints = productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

    // 输入: nums = [1,2,3,4]
    // 输出: [24,12,8,6]
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int l = 1;
        ans[0] = 1;
        // 先把ans[i]乘以nums[i]左侧元素
        for (int i = 1; i < n; i++) {
            ans[i] = l * nums[i - 1];
            l = ans[i];
        }
        int r = 1;
        // 再把ans[i]乘以Nums[i]右侧元素
        for (int i = n - 2; i >= 0; i--) {
            r = r * nums[i + 1];
            ans[i] = ans[i] * r;
        }
        return ans;
    }
}
