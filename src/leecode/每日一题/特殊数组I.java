package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-13 9:35
 */
public class 特殊数组I {
    // 输入：nums = [4,3,1,6]
    // 输出：false
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && (nums[i] + nums[i - 1]) % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
