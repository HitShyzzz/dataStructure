package interview.衍复;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-06 19:53
 */
public class Main1 {
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int target = 11;
        dfs(nums, target, 0, 0);
        System.out.println(ans);
    }

    public static void dfs(int[] nums, int target, int cnt, int index) {
        if (target < 0 || index == nums.length) {
            return;
        }
        if (target == 0) {
            ans = Math.min(ans, cnt);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            dfs(nums, target - nums[i], cnt + 1, i);
        }
    }
}
