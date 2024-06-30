package interview.衍复;

import java.util.PriorityQueue;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 基于快速排序的思想，O(T)=O(N)
 * @date: 2024-06-30 20:20
 */
public class 第K大元素方法2 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }

    // 输入: [3,2,3,1,2,4,5,5,6], k = 4
    // 输出: 4
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // 第K大元素的下标就是n-k，n-1-x+1=k，x=n-k
        return quickSort(nums, 0, n - 1, n - k);
    }


    // k表示在主元priov（包含priov）右侧元素的个数
    public static int quickSort(int[] nums, int l, int r, int k) {
        if (l == r)
            return nums[k];
        int priov = nums[l];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            // 比i小的放左边
            do {
                i++;
            } while (nums[i] < priov);
            // 比i大的放右边
            do {
                j--;
            } while (nums[j] > priov);
            // 跳出循环此时，nums[i]>nums[j]，交换nums[i]和nums[j]
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        // k在j左侧，要找第K大当然在左侧找
        if (j >= k) {
            return quickSort(nums, l, j, k);
        } else {// k在j右侧，要找第K大当然在右侧找
            return quickSort(nums, j + 1, r, k);
        }
    }
}
