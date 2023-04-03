package leecode.剑指offer突击版;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/04/03/10:06
 * @Description:
 */
public class 最长连续序列 {
    /**
     * 先排序再去算最长连续序列的长度，
     * O(T)=O(nlogn)
     * O(S)=O(n)
     *
     * @param nums
     * @return 最长连续序列的长度
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxLen = 1;
        int tmp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                tmp++;
            } else {
                tmp = 1;
            }
            maxLen = Math.max(maxLen, tmp);
        }
        return maxLen;
    }
}
