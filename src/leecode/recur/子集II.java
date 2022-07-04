package leecode.recur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/03/11:07
 * @Description:
 */
public class 子集II {
    private static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
    // private static List<Integer>list=new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        // 这里排序的目的是为了把相同的元素放在一起方便去重！
        recur(nums, 0, visited, new ArrayList<>());
        return ans;
    }

    /**
     * 跟不重复的集合求子集是一样的，只要做好去重处理就好了！
     *
     * @param nums
     * @param index
     */
    public static void recur(int[] nums, int index, boolean[] visited, List<Integer> list) {
        ans.add(new ArrayList<>(list));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                recur(nums, i + 1, visited, list);
                // 回溯
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
