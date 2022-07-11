package leecode.数学;

import leecode.链表.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/11/21:47
 * @Description:
 */
public class 除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /**
     * 最直接的想法，用除法，但要注意处理有0的情况；
     * O(T)=O(n);
     * O(S)=O(1);除了返回的结果占用的额外空间之外，只使用了常熟空间来存储变量！
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int count = 0;// 记录nums数组中0的个数
        int index = 0;// 记录nums[i]==0的下标i
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                index = i;
            } else {
                product *= nums[i];
            }
        }
        // 如果0的个数>1,那么所有的结果都是0；
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            if (count == 1) {// 有1个0，那么除了ans[index]=product之外，其他都是0;
                ans[index] = product;
            }
            if (count == 0) {// 没有0，那么ans[i]=product/nums[i];
                ans[i] = product / nums[i];
            }
        }
        return ans;
    }
}
