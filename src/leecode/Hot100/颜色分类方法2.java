package leecode.Hot100;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-06 13:42
 */
public class 颜色分类方法2 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 输入：nums = [2,0,2,1,1,0]
    // 输出：[0,0,1,1,2,2]

    /**
     * @description: 因为nums[i]只有0，1，2，因此我们一一遍历，只要是0就和左指针交换，只要是2就和右指针交换
     * @return:
     **/
    public static void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && nums[i] < nums[l]) {
                swap(nums, i, l);
                l++;
            } else if (nums[i] == 2 && nums[i] > nums[r]) {
                swap(nums, i, r);
                r--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
