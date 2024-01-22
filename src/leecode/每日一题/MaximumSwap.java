package leecode.每日一题;

import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-01-22 21:57
 */
public class MaximumSwap {
    public static void main(String[] args) {
        int i = maximumSwap(826517);
        System.out.println(i);
    }

    // 826517
    public static int maximumSwap(int num) {
        if (num == 0) {
            return 0;
        }
        int len = (int) Math.log10(num) + 1;
        // 1.先得到每一位数字
        int[] nums = new int[len];
        int index = 0;
        while (num != 0) {
            nums[index++] = num % 10;
            num = num / 10;
        }
        int[] copy = Arrays.copyOf(nums, len);
        Arrays.sort(copy);
        int ans = 0;
        int tmp = 0;
        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (copy[i] != nums[i] && flag) {
                flag = false;
                for (int k = 0; k < i; k++) {
                    // 把当前这个小的数放在较小的数位
                    if (nums[k] == copy[i]) {
                        tmp = nums[i];
                        nums[i] = nums[k];
                        nums[k] = tmp;
                        break;
                    }
                }
            }
            ans = ans * 10 + nums[i];
        }
        return ans;
    }
}
