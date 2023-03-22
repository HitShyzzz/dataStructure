package leecode.动态规划;


import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/09/11:28
 * @Description:
 */
public class 乘机最大子数组 {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int i = maxProduct(nums);
        System.out.println(i);
    }

    /**
     * dp[i]表示以nums[i]结尾的乘积最大子数组！
     * 动态规划，但这道题不同点在于dp[i]不仅和dp[i-1]有关，还和全局的乘积最大子数组和乘积最小子数组有关！
     * 设fmax(i)表示以nums[i]结尾的乘积最大子数组，fmin(i)表示以nums[i]结尾的乘积最小子数组；
     * fmax(i)=max(fmax(i-1)*nums[i],fmin(i-1)*nums[i],nums[i]);
     * fmin(i)=min(fmax(i-1)*nums[i],fmin(i-1*nums[i],nums[i]));
     * O(T)=O(n)，一次遍历数组就好！
     * O(S)=O(1)，利用滚动数组的思想把空间复杂度优化到O(1);
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            int preMax = max;// 这里必须定义这两个变量来记录前面的乘机最大子数组和乘积最小子数组，要不然
            // 在计算min时就会用最新的max,就会出错；
            int preMin = min;
            max = Math.max(Math.max(preMax * nums[i], preMin * nums[i]), nums[i]);
            min = Math.min(Math.min(preMax * nums[i], preMin * nums[i]), nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
