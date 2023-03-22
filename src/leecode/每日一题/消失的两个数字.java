package leecode.每日一题;

import leecode.链表.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/26/19:23
 * @Description:
 */
public class 消失的两个数字 {
    public static void main(String[] args) {
        int[] nums = {1};
        int[] ints = missingTwo(nums);
        for (int i : ints) {
            System.out.print(i + " ");
        }

    }

    public static int[] missingTwo(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        // 找到数组的最大值
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            set.add(nums[i]);
        }
        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        int[] res = new int[2];
        if (ans.size() == 2) {
            for (int i = 0; i < ans.size(); i++) {
                res[i] = ans.get(i);
            }
        } else if (ans.size() == 1) {
            res[0] = ans.get(0);
            res[1] = max + 1;
        } else {
            res[0] = max + 1;
            res[1] = max + 2;
        }
        return res;
    }
}
