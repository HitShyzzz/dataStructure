package leecode.recur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/03/10:45
 * @Description:
 */
public class 子集 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = subsets(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        recur(nums, 0, new ArrayList<>());
        return ans;
    }

    /**
     * 对于每个元素我们都有两个选择，添加当前元素和不添加，然后进行递归回溯就好了；
     * O(T)=O(n*2^n);每个元素都有两种选择，总共有2^n个状态，n个元素时间复杂度就是O(n*2^n);
     * O(S)=O(n);递归空间栈的调用！
     *
     * @param nums
     * @param index
     * @param list
     */
    public static void recur(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // 添加当前元素
        list.add(nums[index]);
        recur(nums, index + 1, list);
        list.remove(list.size() - 1);
        // 不添加当前元素
        recur(nums, index + 1, list);
    }
}
