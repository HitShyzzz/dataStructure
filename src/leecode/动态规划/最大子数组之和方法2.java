package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/10:24
 * @Description:
 */
public class 最大子数组之和方法2 {
    public static void main(String[] args) {
        int [] nums={5,4,-1,7,8};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);

    }

    /**
     * 利用类似滚动数组的思想，把动态规划的空间复杂度优化到O(1)；
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int dp=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            dp=Math.max(dp+nums[i],nums[i]);
            ans=Math.max(ans,dp);
        }
        return ans;
    }
}
