package leecode.模拟;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/07/10:19
 * @Description:
 */
public class 最长连续序列 {
    public static void main(String[] args) {
        int[] nums = {-1, 1,3,0,-1,4,6,5,8,7,9};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    /**
     * 利用HashSet去重，然后对于每段不连续的序列，我们都要从不连续点继续往后走，去更新最长的连续序列，
     * 每个点只会访问一次，O(T)=O(n);
     * O(S)=O(n);需要使用O(n)的空间复杂度来去重！
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        // 用HashSet去重
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            // 相等于从下一个不连续的点继续往后走，前面已经计算过的，就不会进到这个条件里面；
            if (!set.contains(nums[i] - 1)) {
                int curLen = 1;
                int curNum = nums[i];
                while (set.contains(curNum + 1)) {
                    curLen++;
                    curNum++;
                }
                ans = Math.max(ans, curLen);
            }
        }
        return ans;
    }

}
