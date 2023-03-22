package leecode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/04/29/9:37
 * @Description:
 */
public class 无重复的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int ans = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char cur = s.charAt(left);
                window.put(cur, window.get(cur) - 1);
                left++;
            }
            right++;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
