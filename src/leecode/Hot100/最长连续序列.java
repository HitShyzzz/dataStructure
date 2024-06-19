package leecode.Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-06-19 21:44
 */
public class 最长连续序列 {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    // 输入：nums = [100,4,200,1,3,2]
    // 输出：4
    // 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4
    public static int longestConsecutive(int[] nums) {
        int ans = 0;
        // map存储的是cur元素构成的最长连续序列长度
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                // num-1构成的最长连续序列长度,这里num-1和num+1由于缺失num的连通，left和right一定记录的是它们
                // 各自的连续序列长度
                int left = map.getOrDefault(num - 1, 0);
                // num+1构成的最长连续序列长度
                int right = map.getOrDefault(num + 1, 0);
                // cur能构成的最长序列长度就是left+right+1
                int curLen = left + right + 1;
                if (curLen > ans) ans = curLen;
                map.put(num, curLen);
                // 只修改连续序列最小值和最大值的长度，序列中间元素的长度无需更新，用不到
                map.put(num - left, curLen);
                map.put(num + right, curLen);
            }
        }
        return ans;
    }
}
