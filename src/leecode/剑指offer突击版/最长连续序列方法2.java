package leecode.剑指offer突击版;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/03/10:06
 * @Description:
 */
public class 最长连续序列方法2 {
    /**
     * 我们对于元素x,一一去判断x+1,x+2,x+3,...x+y是否存在，如果存在那么当前连续序列长度就是y+1;
     * O(T)=O(n)
     * O(S)=O(n)
     *
     * @param nums
     * @return 最长连续序列的长度
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        // 先用HashSet去重
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < n; i++) {
            // 保证每个数都从连续序列的第一个开始，每个元素只会进入内层循环一次！
            if (!set.contains(nums[i] - 1)) {
                int curNum = nums[i];
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curLen++;
                    curNum++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
