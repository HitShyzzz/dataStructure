package leecode.recur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/06/25/8:34
 * @Description:
 */
public class 全排列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = permute(nums);
        System.out.println(lists.size());
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        recur(nums, 0, list);
        return ans;
    }

    public static void recur(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // 这里直接交换的是list集合，先把list里面加入1，2，3再一直交换就行了；
            Collections.swap(list, index, i);
            recur(nums, index + 1, list);
            Collections.swap(list, index, i);
        }
    }
}
