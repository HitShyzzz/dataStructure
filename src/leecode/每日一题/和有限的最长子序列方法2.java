package leecode.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/03/17/21:02
 * @Description:
 */
public class 和有限的最长子序列方法2 {
    public static void main(String[] args) {
        int[] nums = {736411, 184882, 914641, 37925, 214915};
        int[] queries = {331244, 273144, 118983, 118252, 305688, 718089, 665450};
        int[] ints = answerQueries(nums, queries);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] add = new int[nums.length + 1];
        for (int i = 0; i < add.length; i++) {
            if (i > 0) {
                add[i] = add[i - 1] + nums[i - 1];
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int query = queries[i];
            if (query > add[add.length - 1]) {
                ans[i] = nums.length;
                continue;
            }
            int l = 0;
            int r = add.length - 1;
            int mid = 0;
            boolean flag = false;
            while (l <= r) {
                mid = (l + r) / 2;
                if (add[mid] > query) {
                    r = mid - 1;
                } else if (add[mid] < query) {
                    l = mid + 1;
                } else {
                    ans[i] = mid;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans[i] = l - 1;
            }
        }
        return ans;
    }
}
