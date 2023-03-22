package leecode.动态规划;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/10:12
 * @Description:
 */
public class 最大子数组之和 {
    public static void main(String[] args) {
        int [] nums={5,4,-1,7,8};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);

    }

    /**
     * 简单的动态规划题目，O(T)=O(n),一次遍历就好；O(S)=O(n),需要O(n)的空间来存贮数组！
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int n=nums.length;
        // dp[i]表示以nums[i]结尾的最大子数组之和，我们需要返回所有dp[i]的最大值
        int[]dp=new int[n];
        dp[0]=nums[0];
        int ans=nums[0];
        for(int i=1;i<n;i++){
            dp[i]= Math.max(dp[i-1]+nums[i],nums[i]);
            ans=Math.max(ans,dp[i]);
        }
//        for(int i=0;i<n;i++){
//            System.out.print(dp[i]+" ");
//        }
        return ans;
    }
}
