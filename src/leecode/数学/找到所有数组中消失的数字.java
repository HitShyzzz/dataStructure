package leecode.数学;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/21/22:21
 * @Description:
 */
public class 找到所有数组中消失的数字 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDisappearedNumbers(nums);
        System.out.println(list);
    }

    /**
     * 把nums的数组放到集合中，如果没包含1,...n的数字，就加到结果集里！
     * O(T)=O(n);
     * O(S)=O(n);不算返回结果集的额外空间，还需要O(n)的空间来存储nums的元素！
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
