package leecode.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/10/24/9:43
 * @Description:
 */
public class 分割数组 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 6, 12};
        int i = partitionDisjoint(nums);
        System.out.println(i);
    }
    // [5,0,3,8,6]---》3
    public static int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];// 记录数组每个位置左侧元素(包括它自身)最大值
        Arrays.fill(max, Integer.MIN_VALUE);
        max[0] = nums[0];
        int[] min = new int[n];// 记录数组每个位置右侧元素(不包括它自身)最小值
        Arrays.fill(min, Integer.MAX_VALUE);
        min[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(nums[i], max[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i + 1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (max[i] <= min[i]) {
                ans = Math.min(ans, i + 1);
            }
        }
        return ans;
    }
}
