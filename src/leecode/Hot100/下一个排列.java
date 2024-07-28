package leecode.Hot100;

import javax.swing.*;
import java.util.Arrays;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 找的较小数尽可能靠右，较大数尽可能的小，就是下一个排列
 * @date: 2024-07-28 13:12
 */
public class 下一个排列 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        int minIndex = -1;
        while (i >= 0) {
            // 从右向左找到第一个满足nums[i]<nums[i+1]的nums[i]就是尽可能靠右的较小数
            if (i + 1 < n && nums[i] < nums[i + 1]) {
                minIndex = i;
                break;
            }
            i--;
        }
        int j = n - 1;
        if (minIndex != -1) {
            // 从右向左找到nums[j]>nums[i]的nums[j]就是尽可能小的较大数，因为[i+1,n-1]是降序的
            while (j > i && nums[j] <= nums[minIndex]) {
                j--;
            }
            // 交换ai和aj
            int tmp = nums[minIndex];
            nums[minIndex] = nums[j];
            nums[j] = tmp;
        }
        // 对[i+1,n]升序排序，因为[i+1,n-1]是降序的，只需要双指针依次交换对应元素即可实现升序
        int l = minIndex + 1;
        int r = n - 1;
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            r--;
            l++;
        }
    }
}
