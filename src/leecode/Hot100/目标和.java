package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-02 11:36
 */
public class 目标和 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int targetSumWays = findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }

    static int count = 0;

    // 输入：nums = [1,1,1,1,1], target = 3
    //  输出：5
    //  解释：一共有 5 种方法让最终目标和为 3 。
    //-1 + 1 + 1 + 1 + 1 = 3
    //+1 - 1 + 1 + 1 + 1 = 3
    //+1 + 1 - 1 + 1 + 1 = 3
    //+1 + 1 + 1 - 1 + 1 = 3
    //+1 + 1 + 1 + 1 - 1 = 3
    public static int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target);
        return count;
    }

    public static void dfs(int[] nums, int index, int target) {

        if (index == nums.length) {
            if (target == 0) {
                count++;
            }
            return;
        }
        dfs(nums, index + 1, target - nums[index]);
        dfs(nums, index + 1, target + nums[index]);
    }
}
