package interview.广发银行;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/13/15:44
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        int n=3;
        int[]nums={1,2,10};
        long l = GiftsFromHR(n, nums);
        System.out.println(l);
    }
    public static long GiftsFromHR (int n, int[] nums) {
        // write code here
        Arrays.sort(nums);
        long min=0;
        long[]dp=new long[n];
        for(int i=1;i<n;i++){
            dp[i]=dp[i-1]+nums[i];
        }
        for(int i=0;i<dp.length;i++){
            System.out.println(dp[i]);
        }
        for(int i=0;i<dp.length;i++){
            min+=dp[i];
        }
        return min;
    }
}
