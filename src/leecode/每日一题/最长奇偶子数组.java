package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/16/23:59
 * @Description:
 */
public class 最长奇偶子数组 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 4};
        int threshold = 5;
        int i = longestAlternatingSubarray(nums, threshold);
        System.out.println(i);
    }

    // 输入：nums = [3,2,5,4], threshold = 5
    // 输出：3
    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int l = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                l = i;
                int r = l;
                while (r < n - 1 && (nums[r] + nums[r + 1]) % 2 != 0 && nums[r] <= threshold && nums[r + 1] <= threshold) {
                    r++;
                }
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }
}
