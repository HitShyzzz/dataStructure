package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/10/19:53
 * @Description:
 */
public class 打家劫舍方法2 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int rob = rob(nums);
        System.out.println(rob);
    }

    /**
     * 利用滚动数组的思想把动态规划的空间复杂度优化到O(1)；
     * O(T)=O(n);
     * O(S)=O(1);
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        if (n == 1) {
            return prev;
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dp = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = dp;
            dp = Math.max(dp, prev + nums[i]);
            prev = temp;
        }
        return dp;
    }
}
