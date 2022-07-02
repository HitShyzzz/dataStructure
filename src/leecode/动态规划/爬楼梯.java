package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/16:58
 * @Description:
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        int n=5;
        int i = climbStairs(n);
        System.out.println(i);
    }
    /**
     * 非常简单的最基本的动态规划题目，
     * 设dp[i]为爬到第i个台阶的不同走法，则dp[i]=dp[i-1]+dp[i-2];
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
