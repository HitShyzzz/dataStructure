package leecode.数学;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/18/10:34
 * @Description:
 */
public class 子序列宽度之和 {
    /**
     * 每个子序列的宽度是最大值-最小值，因此我们先把原来的数组排序，对于所有的子序列宽度之和是没有影响的；
     * 然后去考虑nums[i],...nums[j](i<j)，以nums[i]为最小值，nums[j]为最大值的子序列个数就是2^(j-i+1-2)个
     * 那么所有以nums[j]为最大值的子序列之和就是Bj=Σi<j(nums[j]-nums[i])*2^(j-i-1).
     * 然后后去计算Bj,我们最后要算的就是所有的Bj的和；
     *
     * @param nums
     * @return
     */
    public int sumSubseqWidths(int[] nums) {
        int mod = 1000000007;
        long ans = 0;
        Arrays.sort(nums);
        long x = nums[0];
        long y = 2;
        for (int j = 1; j < nums.length; j++) {
            ans = (ans + nums[j] * (y - 1) - x) % mod;
            y = (2 * y) % mod;
            x = (2 * x + nums[j]) % mod;
        }
        return (int) ((ans + mod) % mod);
    }
}
