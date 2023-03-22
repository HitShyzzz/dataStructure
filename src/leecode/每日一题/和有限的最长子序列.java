package leecode.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/17/21:02
 * @Description:
 */
public class 和有限的最长子序列 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] add = new int[nums.length];
        add[0] = nums[0];
        for (int i = 1; i < add.length; i++) {
            add[i] = add[i - 1] + nums[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < add.length; j++) {
                if (add[j] <= queries[i]) {
                    ans[i] = j + 1;
                }
            }
        }
        return ans;
    }
}
