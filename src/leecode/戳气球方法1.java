package leecode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/18/11:04
 * @Description:
 */
public class 戳气球方法1 {
    int[] val;//添加nums[0]和nums[n]为1，方便处理边界
    int[][] solve;//solve[i][j]表示开区间（i，j）填充满气球所能获得的最多硬币数

    public int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        solve = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(solve[i], -1);// 为了方便记录已经递归到的结果，避免重复计算，即记忆化搜索
        }
        return recur(val, 0, n + 1);
    }

    public int recur(int[] val, int left, int right) {
        // 此时开区间内的数为0，直接返回0，也是递归的一个出口。
        if (left >= right - 1) {
            return 0;
        }
        // 记录已经算出的结果，避免重复计算
        if (solve[left][right] != -1) {
            return solve[left][right];
        }
        for (int mid = left + 1; mid < right; mid++) {
            int sum = val[left] * val[mid] * val[right] + recur(val, left, mid) + recur(val, mid, right);
            solve[left][right] = Math.max(sum, solve[left][right]);
        }
        return solve[left][right];
    }
}
