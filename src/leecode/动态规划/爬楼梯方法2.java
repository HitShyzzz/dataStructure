package leecode.动态规划;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/17:07
 * @Description:
 */
public class 爬楼梯方法2 {

    public static void main(String[] args) {
        int n = 5;
        int i = climbStairs(n);
        System.out.println(i);
    }

    /**
     * 可以利用滚动数组的思想把空间复杂度优化到O(1);
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int a = 1;
        int b = 1;
        int dp = 1;
        for (int i = 2; i <= n; i++) {
            dp = a + b;
            a = b;
            b = dp;
        }
        return dp;
    }
}
