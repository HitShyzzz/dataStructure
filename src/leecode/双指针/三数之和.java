package leecode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/20/20:40
 * @Description:
 */
public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, 0, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        for (List list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 先排序再双指针来优化时间复杂度
     * O(T)=O(n^2)，second和third指针是同时移动的，
     * O(S)=O(n)，需要ArrayList来存结果集
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);// 先排序来优化时间复杂度
        for (int first = 0; first < n; first++) {
            // 这里必须要这么做，不这样做会导致添加重复的三元组！
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < n; second++) {
                // 跟first指针处的优化道理是一样的，必须这样做，否则就会添加重复的三元组
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int target = -1 * (nums[first] + nums[second]);
                int third = n - 1;
                while (third > second && nums[third] > target) {
                    third--;
                }
                // 没有满足要求的不同元素三元组
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
