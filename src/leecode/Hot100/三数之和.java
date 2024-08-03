package leecode.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-08-03 10:49
 */
public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = {1, -1, -1, 0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    // 输入：nums = [-1,0,1,2,-1,-4]
    // 输出：[[-1,-1,2],[-1,0,1]]
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            if (first > 0 && (nums[first] == nums[first - 1])) {
                continue;
            }
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && (nums[second] == nums[second - 1])) {
                    continue;
                }
                int target = -(nums[first] + nums[second]);
                int third = n - 1;
                if (nums[third] < target) {
                    continue;
                }
                while (third > second && nums[third] > target) {
                    third--;
                }
                if (third == second) {
                    break;
                }
                if (nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
