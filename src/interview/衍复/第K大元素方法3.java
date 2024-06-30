package interview.衍复;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 基于桶排序的思想，O(T)=O(N)
 * @date: 2024-06-30 20:20
 */
public class 第K大元素方法3 {
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
        int[] budgets = new int[20001];
        for (int i = 0; i < n; i++) {
            // nums[i]范围是[-10000,10000]，为避免下标出现负数，增加偏移量10000
            budgets[nums[i] + 10000]++;
        }
        // 寻找第K大，倒序遍历
        for (int i = 20000; i >= 0; i--) {
            k = k - budgets[i];
            // 减K次为0，那么说明当前下标恰好就是第K大元素
            if (k <= 0) return i - 10000;
        }
        return 0;
    }

}
