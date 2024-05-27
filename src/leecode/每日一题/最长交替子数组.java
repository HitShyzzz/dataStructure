package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-01-23 22:17
 */
public class 最长交替子数组 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6};
        int i = alternatingSubarray(nums);
        System.out.println(i);
    }

    // 输入：nums = [2,3,4,3,4]
    // 输出：4
    // 解释：交替子数组有 [3,4] ，[3,4,3] 和 [3,4,3,4] 。最长的子数组为 [3,4,3,4] ，长度为4 。
    public static int alternatingSubarray(int[] nums) {
        int ans = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = end = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] == (int) Math.pow(-1, j - start - 1)) {
                    end++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans == 1 ? -1 : ans;
    }
}
