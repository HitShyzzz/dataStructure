package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 滚动数组，空间复杂度可降为O(1)
 * @date: 2024-07-06 12:18
 */
public class 交替子数组计数方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0};
        long l = countAlternatingSubarrays(nums);
        System.out.println(l);
    }

    // 输入： nums = [1,0,1,0]
    // 输出： 10
    public static long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int prev = cnt;
            cnt = 1;
            if (i > 0 && nums[i] != nums[i - 1]) {
                cnt = prev + 1;
            }
            ans += cnt;
        }
        return ans;
    }
}

