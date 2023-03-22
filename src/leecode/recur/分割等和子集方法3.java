package leecode.recur;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/20/22:02
 * @Description:
 */
public class 分割等和子集方法3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        boolean b = canPartition(nums);
        System.out.println(b);
    }

    /**
     * 利用滚动数组的思想，把空间复杂度优化到O(target)；
     * O(T)=O(n*target);
     * O(S)=O(target);target=sum/2;
     *
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 != 0 || max > sum / 2) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[target];
    }
}
