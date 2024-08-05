package leecode.每日一题;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 暴力计算，直接超时！
 * @date: 2024-08-05 9:24
 */
public class 不含连续1的非负整数方法2 {
    public static void main(String[] args) {
        int integers = findIntegers(5);
        System.out.println(integers);
    }

    public static int findIntegers(int n) {
        // dp[i]表示根结点为0，高度为i-1的子树中不含连续1的数量
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int pre = 0;
        int res = 0;
        for (int i = 29; i >= 0; i--) {
            int val = 1 << i;
            if ((n & val) != 0) {
                res += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }
            if (i == 0) {
                res++;
            }
        }
        return res;
    }
}
