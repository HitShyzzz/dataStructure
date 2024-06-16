package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-16 15:41
 */
public class 除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] ints = productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

    // 输入: nums = [1,2,3,4]
    // 输出: [24,12,8,6]
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        l[0] = 1;
        int[] r = new int[n];
        r[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = l[i] * r[i];
        }
        return ans;
    }
}
