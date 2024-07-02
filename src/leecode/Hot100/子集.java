package leecode.Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 递归回溯，O(T)=O(2^N),O(S)=O(N)
 * @date: 2024-07-02 21:37
 */
public class 子集 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    // 输入：nums = [1,2,3]
    // 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    static List<List<Integer>> ans = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        recur(nums, 0);
        return ans;
    }

    public static void recur(int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // 添加nums[index]
        list.add(nums[index]);
        recur(nums, index + 1);
        // 回溯
        list.remove(list.size() - 1);
        // 不添加nums[index]
        recur(nums, index + 1);
    }
}
