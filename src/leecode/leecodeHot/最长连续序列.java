package leecode.leecodeHot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/21/9:33
 * @Description:
 */
public class 最长连续序列 {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    // 100,4,200,1,3,2--->1,2,3,4---->4
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer key : set) {
            int maxLen = 1;
            while (set.contains(key + 1)) {
                maxLen++;
                key++;
            }
            ans = Math.max(ans, maxLen);
        }
        return ans;
    }
}
