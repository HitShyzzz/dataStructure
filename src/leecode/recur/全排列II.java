package leecode.recur;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/25/10:45
 * @Description:
 */
public class 全排列II {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists.size());
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> ans = new ArrayList<>();
    private static boolean[] visited;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        // 为了把相同的元素放到一起，便于我们剪枝，进行排序！
        Arrays.sort(nums);
        recur(nums, 0, new ArrayList<>(), visited);
        return ans;
    }

    /**
     * 这里直接交换list并不好，因为有重复的；
     *
     * @param nums
     * @param index
     * @param list
     */
    public static void recur(int[] nums, int index, List<Integer> list, boolean[] visited) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果nums[i]已经访问过了，或者前后两个相等，但前面那个没访问过，就要访问前面那个，当前这个相同的元素就要跳过!
            if ((visited[i] || (i > 0 && nums[i] == nums[i - 1]) && !visited[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            recur(nums, index + 1, list, visited);
            // 回溯，恢复到上一层递归的地方！
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
