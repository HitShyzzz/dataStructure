package leecode.数学;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/21/22:44
 * @Description:
 */
public class 找到所有数组中消失的数字方法2 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDisappearedNumbers(nums);
        System.out.println(list);
    }

    /**
     * 因为nums中的元素都在[1,n]中，我们每遍历到元素x，就把nums[x-1]+n,这样nums[x-1]必然会大于n，
     * 我们再遍历一次数组，如果nums[x]<=n,说明没有x+1出现把它加n,这样就找到了消失的数字，
     * 在对nums[x-1]+n的时候可能前面的元素已经把Nums[x-1]加n了，因此我们需要对nums[x]-1%n,来还原出原来的Nums[x]-1的值！
     * O(T)=O(n);
     * O(S)=O(1);忽略返回结果集占用的空间！
     *
     * @param nums
     * @return
     */
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
