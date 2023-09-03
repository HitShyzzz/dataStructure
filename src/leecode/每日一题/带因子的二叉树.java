package leecode.每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/08/29/21:21
 * @Description:
 */
public class 带因子的二叉树 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 8, 16};
        int i = numFactoredBinaryTrees(arr);
        System.out.println(i);
    }

    private static final int MOD = 1000000007;
    // 输入: arr = [2, 4, 5, 10]
    // 输出: 7
    // 解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].

    /**
     * @param arr
     * @return int
     * @Author Shy
     * @Description 排序+动态规划 设dp[i]表示arr[i]能构成的带因子二叉树总数
     * 那么 if arr[j]是arr[i]的因子，且tmp=dp[i]/dp[j]也包含在数组中，dp[i]=dp[i]+dp[j]*dp[map.get(tmp)]
     * 注意数组范围界限即可！
     * @Date 2023/8/29 21:57
     **/
    public static int numFactoredBinaryTrees(int[] arr) {
        // 先排序
        Arrays.sort(arr);
        int n = arr.length;
        long[] dp = new long[n];
        // key是arr[i],value是i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        dp[0] = 1;
        long ans = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int tmp = arr[i] / arr[j];
                    if (map.containsKey(tmp)) {
                        dp[i] = (dp[i] + dp[j] * dp[map.get(tmp)]) % MOD;
                    }
                }
            }
            ans = (ans + dp[i]) % MOD;
        }
        return (int) ans;
    }
}
