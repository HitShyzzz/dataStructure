package leecode.每日一题;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/11/21/19:42
 * @Description:
 */
public class 美化数组的最少删除数 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3};
        int i = minDeletion(nums);
        System.out.println(i);
    }

    // 输入：nums = [1,1,2,2,3,3]
    // 输出：2
    // 解释：可以删除 nums[0] 和 nums[5] ，这样得到的 nums = [1,2,2,3] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至少需要删除 2 个元素。

    /**
     * @param nums
     * @return int
     * @Author Shy
     * @Description 最优策略就是每次都去删除下标i为偶数，且nums[i]==nums[i+1]的元素！
     * @Date 2023/11/21 20:12
     **/
    public static int minDeletion(int[] nums) {
        int cnt = 0;
        boolean flag = true;
        int n = nums.length;
        for (int i = 0; i + 1 < n; i++) {
            if (nums[i] == nums[i + 1] && flag) {
                cnt++;
            } else {
                flag = !flag;
            }
        }
        if ((n - cnt) % 2 != 0) {
            cnt++;
        }
        return cnt;
    }
}
