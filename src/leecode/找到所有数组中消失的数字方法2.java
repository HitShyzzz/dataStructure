package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/29/11:39
 * @Description:
 */
public class 找到所有数组中消失的数字方法2 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDisappearedNumbers(nums);
        for(Integer i:list){
            System.out.print(i+" ");
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
