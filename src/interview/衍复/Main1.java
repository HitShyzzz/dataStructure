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
        dfs(nums, target, 0);
        System.out.println(ans);
    }

    public static void dfs(int[] nums, int target, int cnt) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans = Math.min(ans, cnt);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, target - nums[i], cnt + 1);
        }
    }


}
