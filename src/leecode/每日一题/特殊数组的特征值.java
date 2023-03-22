package leecode.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/12/9:15
 * @Description:
 */
public class 特殊数组的特征值 {

    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // 降序排列
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // nums[i-1]>=i,因为是降序排列，那么此时恰好有i个元素>=i,而且nums[i]<i,恰好有n-i个元素是小于i的。
        // i==n此时是说后面没有元素了，n个元素>=n;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }
}
