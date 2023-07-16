package leecode.剑指offer突击版;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/07/16/13:28
 * @Description:
 */
public class 排列的数目 {
    int cnt[];// 用来记录当前和为sum时，元素之和为target的方案数目

    // 输入：nums = [1,2,3], target = 4
    // 输出：7
    // 解释：
    // 所有可能的组合为：
    // (1, 1, 1, 1)
    // (1, 1, 2)
    // (1, 2, 1)
    // (1, 3)
    // (2, 1, 1)
    // (2, 2)
    // (3, 1)
    //请注意，顺序不同的序列被视作不同的组合。
    public int combinationSum4(int[] nums, int target) {
        cnt = new int[target + 1];
        Arrays.fill(cnt, -2);
        return dfs(nums, target, 0);
    }

    /**
     * @param nums
     * @param target
     * @param sum
     * @return 当前元素之和为sum时，找出元素之和为target的方案数目
     */
    public int dfs(int[] nums, int target, int sum) {
        if (sum == target) {
            return 1;
        }
        if (sum > target) {
            return 0;
        }
        if (cnt[sum] != -2) {
            return cnt[sum];
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int nexCnt = dfs(nums, target, sum + nums[i]);
            if (nexCnt == 0) {
                continue;
            }
            total += nexCnt;
        }
        cnt[sum] = total;
        return total;
    }
}
