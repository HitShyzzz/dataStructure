package leecode.top50;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 拿较小数和较大数进行交换
 * @date: 2024-08-31 8:33
 */
public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        int minIndex = -1;
        // 从后往前找到第一个顺序对(i,i+1)，那么[i+1,n-1]必然是降序序列
        while (i >= 0) {
            if (i + 1 < n && nums[i] < nums[i + 1]) {
                // 尽量靠右的较小数
                minIndex = i;
                break;
            }
            i--;
        }
        // 从[i+1,n-1]中找尽量小的较大数
        int j = n - 1;
        if (minIndex != -1) {
            while (j > minIndex && nums[j] <= nums[minIndex]) {
                j--;
            }
            // 交换较小数和较大数
            int tmp = nums[minIndex];
            nums[minIndex] = nums[j];
            nums[j] = tmp;
        }
        // 把[minIndex+1,n-1]升序排列,因为这段已经是降序，因此只需要双指针交换元素即可
        int l = minIndex + 1;
        int r = n - 1;
        while (l < r) {
            int x = nums[l];
            nums[l] = nums[r];
            nums[r] = x;
            l++;
            r--;
        }
    }
}
