package interview.衍复;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-30 20:00
 */
public class 目标和 {
    static int cnt = 0;

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int cnt1 = getCnt(nums, target);
        System.out.println(cnt1);
    }

    public static int getCnt(int[] nums, int target) {
        dfs(nums, target, 0);
        return cnt;
    }

    // 用加减乘除四种运算符号连接nums元素，使得最终运算结果为target的不同方案数
    public static void dfs(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                cnt++;
            }
            return;
        }
        dfs(nums, target + nums[index], index + 1);
        dfs(nums, target - nums[index], index + 1);
        dfs(nums, target * nums[index], index + 1);
        dfs(nums, target / nums[index], index + 1);
    }

}
