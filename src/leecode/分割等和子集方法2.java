package leecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/26/16:16
 * @Description:
 */
public class 分割等和子集方法2 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean c = canPartition(nums);
        System.out.println(c);
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];// dp[j]表示能否从数组中找到一些元素使得这些元素的和为j;
        dp[0] = true;// 这是非常重要的一步；它对应的就是nums[i]自己成为一组的情况；nums={1,5,11,5};
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];// 这里的dp[j]||dp[j-nums[i]]对应的就是j自己成为一组的情况！
            }
        }
        return dp[target];
    }
}

